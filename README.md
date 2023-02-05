# Student Management System

## Creating the Database in MySQL
<p> Lets create the Database where the Student details, roles are stored. Follow the following instructions for the same. </p>

1. Open the MySql workbench.
2. Create a new SQL file.
3. Create new schema: 

        CREATE SCHEMA `student_mgmt_sys` ;
4. Run the Springboot application for creating corresponding tables in the schema.
5. Update the **users** table with following info:<br>

       INSERT INTO `student_mgmt_sys`.`users` (`user_id`, `password`, `username`) VALUES ('1', '$2a$14$F4LqRYeiouX83AEcorwkIuxNszxWkIG3gDTlSpQS8wz4IYtWorcuy', 'admin');
       INSERT INTO `student_mgmt_sys`.`users` (`user_id`, `password`, `username`) VALUES ('2', '$2a$14$.FnBITOcpAQ41iX230thjuq6.OXXgT4bamSJugC1l46Fb80ePsyfa', 'user');
6. Update the **roles** table with following info:<br>

        INSERT INTO `student_mgmt_sys`.`roles` (`role_id`, `name`) VALUES ('1', 'admin');
        INSERT INTO `student_mgmt_sys`.`roles` (`role_id`, `name`) VALUES ('2', 'user');    
 7. Update the **user_roles** table with following info:<br>

        INSERT INTO `student_mgmt_sys`.`user_roles` (`user_id`,`role_id`) VALUES ('1','1');
        INSERT INTO `student_mgmt_sys`.`user_roles` (`user_id`,`role_id`) VALUES ('2', '2'); 
8. Restart the Springboot application.
9. Try to login to the application with following username - password sets:
    
        user-user
        admin-admin
