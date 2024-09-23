select tmp.student_id, tmp.student_name, tmp.subject_name, count(b.subject_name) as attended_exams
from (select * from subjects s join students a on 1 =1) tmp
         left join examinations b on tmp.student_id = b.student_id and tmp.subject_name = b.subject_name
group by tmp.student_id, tmp.student_name, tmp.subject_name
order by tmp.student_id, tmp.subject_name
