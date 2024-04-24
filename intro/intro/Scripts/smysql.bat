::
:: Script Arr^t/Relance conteneur MySql 
::
@echo OFF
set OPTION=%1
if %OPTION%. == start. (
	docker run -d --name mysql --rm -p3307:3306 -e MYSQL_ROOT_PASSWORD="Hitema&2024" -v "D:\Ecoles\HITEMA\2023-2024\M1 - Dev Web_IoT\JEE\Data\mysql":/var/lib/mysql mysql:8.2
)else if %OPTION%. == stop. (
	docker stop mysql
) else (
	@echo %0% [start^|stop] 
)
