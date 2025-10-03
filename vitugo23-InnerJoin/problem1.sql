SELECT student.id, student.student_name
from class
inner join student ON class.class_title = student.class_title
 WHERE class.teacher_name = 'Ms. Lovelace';