import Lab.Exceptions.InvalidTonnageException;
import Lab.Model.Ship;
import Lab.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = InvalidTonnageException.class) // ✅ Add it here!
@Service
public class ShipService {
    ShipRepository shipRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository){
        this.shipRepository = shipRepository;
    }

    /**
     * this is a bad way to save a list to the repository as you can just use the .saveAll method provided the table
     * has a CHECK constraint to check tonnage, but this gets the point across for the importance of @Transactional
     * @param ships transient ship entities
     * @throws InvalidTonnageException ships can not have negative tonnage (they'd sink)
     */
    public List<Ship> addListShips(List<Ship> ships) throws InvalidTonnageException {
        List<Ship> persistedShips = new ArrayList<>();
        for (Ship ship : ships) {
            if (ship.getTonnage() <= 0) {
                throw new InvalidTonnageException(); // ❗️ This will trigger the rollback
            }
            persistedShips.add(shipRepository.save(ship));
        }
        return persistedShips;
    }

    /**
     * @return all ship entities
     */
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    /**
     * @return ship entity by id
     */
    public Ship getShipById(long id) {
        return shipRepository.findById(id).orElse(null);
    }
}
