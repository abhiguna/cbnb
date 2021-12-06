DROP PROCEDURE IF EXISTS sort_dname;
DELIMITER $$ CREATE PROCEDURE store_dname() -- Write your procedure content below
BEGIN
SELECT Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type
FROM Dorm
GROUP BY dorm_id
ORDER BY Dorm.name;
END $$ DELIMITER;
-- Test Case: Sort by dorm name
-- CALL store_dname();
-- TODO: SORT BY DORM TYPE
DROP PROCEDURE IF EXISTS sort_dtype;
DELIMITER $$ CREATE PROCEDURE store_dtype() -- Write your procedure content below
BEGIN
SELECT Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type
FROM Dorm
GROUP BY dorm_id
ORDER BY Dorm.dorm_type;
END $$ DELIMITER;
-- CALL store_dtype()
-- TODO: SORT BY TOTAL GUESTS
DROP PROCEDURE IF EXISTS sort_tguests;
DELIMITER $$ CREATE PROCEDURE store_tguests() -- Write your procedure content below
BEGIN
SELECT Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type
FROM Dorm
GROUP BY dorm_id
ORDER BY SUM(Dorm.total_guests) ASC
END $$ DELIMITER;
-- Test Case: Sort by total guests
-- CALL store_tguests();
-- TODO: SORT BY ROOMS AVAILABLE
DROP PROCEDURE IF EXISTS sort_ravailable;
DELIMITER $$ CREATE PROCEDURE store_ravailable() -- Write your procedure content below
BEGIN
SELECT Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type
FROM Dorm
GROUP BY dorm_id
ORDER BY Dorm.rooms_available;
END $$ DELIMITER;
-- CALL store_ravailable();
-- TODO: SORT BY ALL
DROP PROCEDURE IF EXISTS store_all;
DELIMITER $$ CREATE PROCEDURE store_all() -- Write your procedure content below
BEGIN
SELECT Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type
FROM Dorm
GROUP BY Dorm.name,
    Dorm.address,
    Dorm.total_guests,
    Dorm.rooms_available,
    Dorm.dorm_type;
END $$ DELIMITER;
-- CALL store_all();
