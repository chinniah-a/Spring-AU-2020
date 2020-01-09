CREATE DEFINER=`root`@`localhost` PROCEDURE `paginate`(in  page_no int, in records_per_page int)
BEGIN
declare start_point int default 0;
set start_point = page_no-1;
set start_point = start_point*records_per_page;
SELECT 
    *
FROM
    Student
LIMIT START_POINT , RECORDS_PER_PAGE;
END