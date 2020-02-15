-- :name create-user!* :! :n
-- :doc creates a new user record
INSERT INTO users
(login, first_name, last_name, city, email, pass)
VALUES (:login, :first_name, :last_name, :city, :email, :pass)

-- :name update-user! :! :n
-- :doc updates an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, city = :city, email = :email
WHERE login = :login

-- :name get-user-for-auth* :? :1
-- :doc retrieves a user record given the id
SELECT * FROM users
WHERE login = :login

-- :name delete-user! :! :n
-- :doc deletes a user record given the id
DELETE FROM users
WHERE login = :login
