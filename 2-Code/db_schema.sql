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
	FOREIGN KEY(uID) REFERENCES University(univ_id) ON DELETE CASCADE
);

CREATE TABLE Room (
    room_id VARCHAR(50) NOT NULL,
    room_num INT NOT NULL,
    dID VARCHAR(30),
    open_date DATE,
    end_date DATE,
    next_available_date DATE,
    max_capacity INT,
    PRIMARY KEY(room_id),
    FOREIGN KEY(dID) REFERENCES Dorm(name) ON DELETE CASCADE
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
    gID VaRCHAR(50) NOT NULL,
    rID VARCHAR(50) NOT NULL,
    dID VARCHAR(30) NOT NULL,
    booking_date DATE NOT NULL, /* Format: YYYY-MM-DD */
    num_guests INT,
    PRIMARY KEY(gID, rID, dID, booking_date),
    FOREIGN KEY (gID) REFERENCES Guest(guest_id)
        ON DELETE CASCADE,
    FOREIGN KEY (rID) REFERENCES Room(room_id),
    FOREIGN KEY (dID) REFERENCES Dorm(name)
);

CREATE TABLE Guest (
    guest_id VARCHAR(50) NOT NULL,
    name VARCHAR(30),
    PRIMARY KEY(guest_id)
);

SET FOREIGN_KEY_CHECKS=1;
