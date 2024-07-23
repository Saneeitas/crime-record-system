CREATE TABLE criminals (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10),
    address VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE crimes (
    id SERIAL PRIMARY KEY,
    criminal_id INT NOT NULL,
    crime_type VARCHAR(100) NOT NULL,
    description TEXT,
    date_of_crime DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (criminal_id) REFERENCES criminals(id) ON DELETE CASCADE
);

CREATE TABLE punishments (
    id SERIAL PRIMARY KEY,
    crime_id INT NOT NULL,
    punishment_type VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (crime_id) REFERENCES crimes(id) ON DELETE CASCADE
);
