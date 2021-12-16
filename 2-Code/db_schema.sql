SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS University;
DROP TABLE IF EXISTS Dorm;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Guest;

CREATE TABLE University (
	name VARCHAR(30) NOT NULL,
	city VARCHAR(20),
	state VARCHAR (20),
	country VARCHAR (20),
	building_cnt INT,
	guest_cnt INT,
	PRIMARY KEY(name)
);

CREATE TABLE Dorm (
	name VARCHAR(30) NOT NULL,
	uID VARCHAR(30),
	address VARCHAR (100),
	total_guests INT,
	rooms_available INT,
	dorm_type VARCHAR(10), /* boys | girls | all */
	PRIMARY KEY(name),
	FOREIGN KEY(uID) REFERENCES University(name) ON DELETE CASCADE
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
