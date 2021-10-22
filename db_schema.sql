SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS University;
DROP TABLE IF EXISTS Dorm;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Waitlist;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Guest;

CREATE TABLE University (
	univ_id INT NOT NULL,
	name VARCHAR(30),
	city VARCHAR(20),
	state VARCHAR (20),
	country VARCHAR (20),
	building_cnt INT,
	guest_cnt INT,
	PRIMARY KEY(univ_id)
);

CREATE TABLE Dorm (
	dorm_id INT NOT NULL,
	uID INT,
	name VARCHAR(30),
	address VARCHAR (100),
	total_guests INT,
	rooms_available INT,
	dorm_type VARCHAR(10), /* boys | girls | all */
	PRIMARY KEY(dorm_id),
	FOREIGN KEY(uID) REFERENCES University(univ_id)
);

CREATE TABLE Room (
	room_id INT NOT NULL,
	dID INT,
	open_date DATE,
	end_date DATE,
	next_available_date DATE,
	max_capacity INT,
	PRIMARY KEY(room_id),
	FOREIGN KEY(dID) REFERENCES Dorm(dorm_id)
);

CREATE TABLE Waitlist (
	waitlist_id INT NOT NULL,
	gID INT,
	rID INT,
	dID INT,
	requested_date DATE,
	total_in_queue INT,
	pos_in_queue INT,
	PRIMARY KEY(waitlist_id),
	FOREIGN KEY(gID, rID, dID, requested_date) REFERENCES Booking(gID, rID, dID, booking_date)
);

CREATE TABLE Booking (
	gID INT NOT NULL,
	rID INT NOT NULL,
	dID INT NOT NULL,
	booking_date DATE NOT NULL, /* Format: YYYY-MM-DD */
	booking_start DATE,
	booking_end DATE,
	num_guests INT,
	payment_due DECIMAL(8, 2),
	wID INT,
	PRIMARY KEY(gID, rID, dID, booking_date),
	FOREIGN KEY (gID) REFERENCES Guest(guest_id),
	FOREIGN KEY (rID) REFERENCES Room(room_id),
	FOREIGN KEY (dID) REFERENCES Dorm(dorm_id),
	FOREIGN KEY (wID) REFERENCES Waitlist(waitlist_id)

);

CREATE TABLE Guest (
	guest_id INT NOT NULL,
	name VARCHAR(30),
	email VARCHAR(50),
	PRIMARY KEY(guest_id)
);

SET FOREIGN_KEY_CHECKS=1;