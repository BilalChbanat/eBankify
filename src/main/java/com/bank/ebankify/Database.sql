CREATE TYPE role_enum AS ENUM ('ADMIN', 'USER', 'EMPLOYEE');

CREATE TYPE transaction_type_enum AS ENUM ('CLASSIC', 'INSTANT', 'RECURRING');

CREATE TYPE transaction_status_enum AS ENUM ('APPROVED', 'REJECTED', 'PENDING');

CREATE TYPE loan_status_enum AS ENUM ('PENDING', 'APPROVED', 'REJECTED');

CREATE TYPE invoice_status_enum AS ENUM ('PAID', 'UNPAID', 'OVERDUE');

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       age INTEGER NOT NULL CHECK (age >= 0),
                       monthly_income DOUBLE PRECISION NOT NULL,
                       credit_score INTEGER NOT NULL ,
                       role role_enum NOT NULL
);

CREATE TABLE bank_accounts (
                               id SERIAL PRIMARY KEY,
                               account_number VARCHAR(20) NOT NULL UNIQUE,
                               balance DOUBLE PRECISION NOT NULL ,
                               owner_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              type transaction_type_enum NOT NULL,
                              amount DOUBLE PRECISION NOT NULL CHECK (amount >= 0),
                              date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              account_from_id INTEGER REFERENCES bank_accounts(id) ON DELETE CASCADE,
                              account_to_id INTEGER REFERENCES bank_accounts(id) ON DELETE CASCADE,
                              fee DOUBLE PRECISION DEFAULT 0,
                              status transaction_status_enum NOT NULL
);

CREATE TABLE loans (
                       id SERIAL PRIMARY KEY,
                       amount DOUBLE PRECISION NOT NULL CHECK (amount > 0),
                       interest_rate DOUBLE PRECISION NOT NULL CHECK (interest_rate >= 0),
                       duration INTEGER NOT NULL CHECK (duration > 0),
                       eligibility_criteria TEXT,
                       status loan_status_enum NOT NULL,
                       user_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE invoices (
                          id SERIAL PRIMARY KEY,
                          amount_due DOUBLE PRECISION NOT NULL CHECK (amount_due >= 0),
                          due_date DATE NOT NULL,
                          status invoice_status_enum NOT NULL,
                          user_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);

ALTER TABLE bank_accounts
    ADD COLUMN is_active BOOLEAN DEFAULT TRUE;
