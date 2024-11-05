-- Updated table names to avoid reserved keyword conflicts
CREATE TABLE `User` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL
);

CREATE TABLE `Folder` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `Attachment` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `mail_id` BIGINT UNSIGNED NOT NULL,
    `file_path` VARCHAR(255) NOT NULL,
    `file_name` VARCHAR(255) NOT NULL,
    `file_size` BIGINT NOT NULL
);

CREATE TABLE `Mail` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `from_user_id` BIGINT UNSIGNED NOT NULL,
    `subject` VARCHAR(255) NOT NULL,
    `body` TEXT NOT NULL,
    `priority` TINYINT NOT NULL,
    `date_time` DATETIME NOT NULL,
    `status` TINYINT NOT NULL
);

CREATE TABLE `AddressBook` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `email_addresses` VARCHAR(255) NOT NULL
);

CREATE TABLE `MailDelivery` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `mail_id` BIGINT UNSIGNED NOT NULL,
    `to_user_id` BIGINT UNSIGNED NOT NULL,
    `folder_id` BIGINT UNSIGNED NULL,
    `is_read` BOOLEAN NOT NULL DEFAULT FALSE,
    `is_flag` BOOLEAN NOT NULL DEFAULT FALSE,
    `is_trash` BOOLEAN NOT NULL DEFAULT FALSE
);

-- Foreign key constraints
ALTER TABLE `Folder`
    ADD CONSTRAINT `folder_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);

ALTER TABLE `AddressBook`
    ADD CONSTRAINT `addressbook_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);

ALTER TABLE `Attachment`
    ADD CONSTRAINT `attachment_mail_id_foreign` FOREIGN KEY (`mail_id`) REFERENCES `Mail` (`id`);

ALTER TABLE `MailDelivery`
    ADD CONSTRAINT `maildelivery_mail_id_foreign` FOREIGN KEY (`mail_id`) REFERENCES `Mail` (`id`);

ALTER TABLE `MailDelivery`
    ADD CONSTRAINT `maildelivery_to_user_id_foreign` FOREIGN KEY (`to_user_id`) REFERENCES `User` (`id`);

ALTER TABLE `Mail`
    ADD CONSTRAINT `mail_from_user_id_foreign` FOREIGN KEY (`from_user_id`) REFERENCES `User` (`id`);

ALTER TABLE `MailDelivery`
    ADD CONSTRAINT `maildelivery_folder_id_foreign` FOREIGN KEY (`folder_id`) REFERENCES `Folder` (`id`);

-- Unique constraints
ALTER TABLE `User` ADD UNIQUE `user_user_name_unique`(`user_name`);
ALTER TABLE `User` ADD UNIQUE `user_email_unique`(`email`);

