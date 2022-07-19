DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `username`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    `password`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    `phone`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    `status`            int,
    `authority`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    PRIMARY KEY (`id`) USING BTREE
)AUTO_INCREMENT = 1


