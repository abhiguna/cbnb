DROP TABLE IF EXISTS Guest;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Waitlist;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Dorm;
DROP TABLE IF EXISTS University;

CREATE TABLE Guest (
	guest_id INT NOT NULL,
	name VARCHAR(30),
	email VARCHAR(50),
	PRIMARY KEY(guest_id)
);

CREATE TABLE Booking (
	gID INT NOT NULL,
	room_id INT NOT NULL,
	booking_date DATE NOT NULL, /* Format: YYYY-MM-DD */
	booking_start DATE,
	booking_end DATE,
	num_guests INT,
	payment_due DECIMAL(8, 2),
	wID INT,
	PRIMARY KEY(gID, room_id, booking_date),
	FOREIGN KEY (wID) REFERENCES Waitlist(waitlist_id),
	FOREIGN KEY (gID) REFERENCES Guest(guest_id)
);

CREATE TABLE Waitlist (

);

CREATE TABLE Room (

);

CREATE TABLE Dorm (

);

CREATE TABLE University (

);