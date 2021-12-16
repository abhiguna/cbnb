CREATE DEFINER=`root`@`%` PROCEDURE `num_spots`(IN date Date, IN dormID VARCHAR(50), OUT spots int)
BEGIN
	DECLARE cap INT;
    DECLARE booked INT;
	SELECT COALESCE(SUM(max_capacity), 0) INTO cap FROM Room WHERE dID = dormID AND date >= open_date AND date <= end_date;
    SELECT COALESCE(SUM(num_guests), 0) INTO booked FROM Booking WHERE dID = dormID AND booking_date = date;
    SELECT cap - booked INTO spots;
    
    UPDATE Dorm SET rooms_available = cap - booked WHERE name = dormID;
END
