CREATE DATABASE tours;

use tours;

CREATE TABLE `Tour` (
    `tour_id` int  NOT NULL AUTO_INCREMENT,
    `tour_name` varchar(255)  NOT NULL ,
    `brief_description` varchar(255)  NOT NULL ,
    `detail_description` varchar(255)  NOT NULL ,
    `price` double  NOT NULL ,
    `available_slots` int  NOT NULL ,
    `tour_category_id` int  NOT NULL ,
    `image_location` varchar(255)  NOT NULL ,
    PRIMARY KEY (
        `tour_id`
    )
);

CREATE TABLE `Category` (
    `category_id` int  NOT NULL AUTO_INCREMENT,
    `category_name` varchar(255)  NOT NULL ,
    `category_description` varchar(255)  NOT NULL ,
    `category_image` varchar(255)  NOT NULL ,
    PRIMARY KEY (
        `category_id`
    )
);

CREATE TABLE `User` (
    `user_id` int  NOT NULL AUTO_INCREMENT,
    `username` varchar(255)  NOT NULL ,
    `password` varchar(255)  NOT NULL ,
    `role` varchar(255)  NOT NULL ,
    `email` varchar(255)  NOT NULL ,
    `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (
        `user_id`
    )
);

CREATE TABLE `Booking` (
    `user_id` int  NOT NULL ,
    `tour_id` int  NOT NULL ,
    `created_at` TIMESTAMP NOT NULL DEFAULT NOW() 
);

CREATE TABLE `Review` (
    `review_id` int  NOT NULL AUTO_INCREMENT,
    `tour_id` int  NOT NULL ,
    `user_id` int  NOT NULL ,
    `review` varchar(255)  NOT NULL ,
    PRIMARY KEY (
        `review_id`
    )
);

ALTER TABLE `Tour` ADD CONSTRAINT `fk_Tour_tour_category_id` FOREIGN KEY(`tour_category_id`)
REFERENCES `Category` (`category_id`);

ALTER TABLE `Booking` ADD CONSTRAINT `fk_Booking_user_id` FOREIGN KEY(`user_id`)
REFERENCES `User` (`user_id`);

ALTER TABLE `Booking` ADD CONSTRAINT `fk_Booking_tour_id` FOREIGN KEY(`tour_id`)
REFERENCES `Tour` (`tour_id`);

ALTER TABLE `Review` ADD CONSTRAINT `fk_Review_tour_id` FOREIGN KEY(`tour_id`)
REFERENCES `Tour` (`tour_id`);

ALTER TABLE `Review` ADD CONSTRAINT `fk_Review_user_id` FOREIGN KEY(`user_id`)
REFERENCES `User` (`user_id`);

INSERT INTO user (username, password, role, email)
VALUES ('andrew', 'andrewp', 'member', 'andrew@gmail.com');

INSERT INTO category (category_name, category_description, category_image)
VALUES ('Cooking', 'More than just a cooking class, these are hands-on culinary experiences that serve up great flavours and lots of fun! Delve into our food culture & learn how to cook local favourites with our expert chef!', 'https://www.letsgotoursingapore.com/wp-content/uploads/LGC-main-pic-300x225.jpg'),
('Boat', 'Take on the seas and rediscover Singapore from a different perspective! Discover the North Eastern Banks of Singapore, be in touch with nature and get upclose to Kelongs & Fish Farms.', 'https://www.letsgotoursingapore.com/wp-content/uploads/Kelong-main-pic-300x225.jpg'), 
('Bike', 'Explore Singapore on carefully-designed routes with friendly local guides. With the wind in your hair, get behind the handlebar to learn a little history and soak in the city\'s breathtaking sights!', 'https://www.letsgotoursingapore.com/wp-content/uploads/LGB-main-300x225.jpg');

INSERT INTO tour (tour_name, brief_description, detail_description, price, available_slots, tour_category_id, image_location)
VALUES ('tour1', 'breif_description1', 'detail_description1', '123', '1', '1', 'image_location_1'),
('tour2', 'breif_description2', 'detail_description2', '223', '2', '1', 'image_location_2'), 
('tour3', 'breif_description3', 'detail_description3', '323', '3', '2', 'image_location_3');
