ALTER TABLE `person` 
ADD COLUMN `birth_day` DATE NOT NULL DEFAULT '1900-01-01',
ADD COLUMN `phone_number` VARCHAR(20) NOT NULL DEFAULT 'N/A';

UPDATE `person`
SET `birth_day` = '1900-01-01', `phone_number` = 'N/A'
WHERE `birth_day` IS NULL OR `phone_number` IS NULL;
