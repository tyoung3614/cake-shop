
insert into client (name, phone, email)
values ('Jon Smith', '9311026001', 'jonsmith@gmail.com'), 
('Deb Johnson', '1023945867', 'debjohn@gmail.com'),
('Tom Brady', '1012921001', 'tombrady@gmail.com'),
('Kendall Jenner', '6750178220', 'kendalljenner@gmail.com')

insert into cake (name, client_id, price)
values (:cakeName, 1, 17.50), ('wedding cake', 2, 200.00), 
('gluten free cake', 3, 25.00), ('holiday cake', 4, 30.50);


insert into type (type_text) values ('chocolate'),('vanilla'),('strawberry'),('cannoli')
