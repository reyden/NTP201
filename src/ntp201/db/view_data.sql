Select DISTINCT e.employee_no AS 'Employee No' , r.item_no AS 'Item No', e.ofds AS 'FDS', e.firstname AS 'Firstname',e.middlename AS 'Middlename',e.lastname AS 'Lastname', 
e.name_extension AS 'Name extension', e.birthdate AS 'Birthday', e.sex AS 'Sex', r.job_title AS 'Position', r.unit AS 'Section', r.highest_education, r.last_promotion, 
r.promotion_date, r.work_status FROM TB_employee e, TB_employee_record r WHERE e.employee_id = r.employee_id
