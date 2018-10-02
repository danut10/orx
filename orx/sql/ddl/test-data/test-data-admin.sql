-- tenant
INSERT INTO tenant(id, name) VALUES 
	  (1, 'Cegeka Romania')
	, (2, 'GFM')
	;

-- role
INSERT INTO role(id, tenant_id, name) VALUES 
	  (1, NULL, 'sysadmin')
	, (2, 1, 'admin')
	, (3, 1, 'robot')
	;

-- user
INSERT INTO user(id, role_id, name, email_address, password) VALUES 
	  (1, 1, 'Sysadmin', 'sysadmin@orx.jdmx.ro', 'admin')
	, (2, 1, 'Dan Maxim','dan.maxim@cegeka.com', 'dan')
	, (3, 1, 'Andrei Pavel','andrei.pavel@cegeka.com', 'andrei')
	, (4, 1, 'Alex Polatos','alex.polatos@cegeka.com', 'alex')
	;
