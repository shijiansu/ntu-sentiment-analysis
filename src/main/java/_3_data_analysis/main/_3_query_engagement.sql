# for table 10
# summary of engagement level on each Facebook pages
SELECT facebook_page,
sum(case when engagement >= 0  and engagement <= 5   then 1 else 0 end) as " 0<e<= 5",
sum(case when engagement > 5  and engagement <= 10  then 1 else 0 end) as " 5<e<=10",
sum(case when engagement > 10 and engagement <= 20  then 1 else 0 end) as "10<e<=20",
sum(case when engagement > 20 and engagement <= 30  then 1 else 0 end) as "20<e<=30",
sum(case when engagement > 30 and engagement <= 40  then 1 else 0 end) as "30<e<=40",
sum(case when engagement > 40 and engagement <= 50  then 1 else 0 end) as "40<e<=50",
sum(case when engagement > 50 and engagement <= 100 then 1 else 0 end) as "50<e<=100",
sum(case when engagement > 100                      then 1 else 0 end) as "100<e",
count(*)
FROM `ntu-msis-ci`._1_post group by facebook_page;
