create table department_model
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table employee_model
(
    department_id int          null,
    dob           date         null,
    gender        tinyint      null,
    salary        double       not null,
    id            binary(16)   not null
        primary key,
    name          varchar(255) null,
    phone         varchar(255) null,
    constraint FK6x660s16w5t8t6fwdnrypt7xq
        foreign key (department_id) references department_model (id),
    check (`gender` between 0 and 1)
);

INSERT INTO employee_2024.department_model (id, name) VALUES (1, 'Quản lý');
INSERT INTO employee_2024.department_model (id, name) VALUES (2, 'Dev');
INSERT INTO employee_2024.department_model (id, name) VALUES (3, 'PO');


INSERT INTO employee_2024.employee_model (department_id, dob, gender, salary, id, name, phone) VALUES (2, '2024-12-02', 1, 120000000, 0x31323030303030303000000000000000, 'Sinh', '0792125792');
INSERT INTO employee_2024.employee_model (department_id, dob, gender, salary, id, name, phone) VALUES (3, '2024-12-09', 0, 12000000000, 0x426F8E78826A4FD9A149D1F029BEF496, 'sinh1', '872342378');
INSERT INTO employee_2024.employee_model (department_id, dob, gender, salary, id, name, phone) VALUES (3, '2024-12-16', 0, 10000000, 0xF47C9BFBDCD14E3C9D07487E6FA2E0EE, 'loan', '0332042241');
