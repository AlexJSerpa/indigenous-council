
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    role VARCHAR(20) CHECK (role IN ('Admin', 'User')) DEFAULT 'User',
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE indigenous_communities (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    reserve_name VARCHAR(100) NOT NULL,
    family_number INT CHECK (family_number >= 0),
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE indigenous (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    identification_type VARCHAR(50) NOT NULL,
    identification_number VARCHAR(50) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    family_member VARCHAR(20),
    gender VARCHAR(20) CHECK (gender IN ('Male', 'Female', 'Other')) NOT NULL,
    marital_status VARCHAR(20) CHECK (marital_status IN ('Single', 'Married', 'Divorced', 'Widowed')),
    profession VARCHAR(200),
    address VARCHAR(200),
    phone VARCHAR(15),
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE families (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    indigenous_id UUID NOT NULL,
    indigenous_community_id UUID NOT NULL,
    FOREIGN KEY (indigenous_id) REFERENCES indigenous(id) ON DELETE CASCADE,
    FOREIGN KEY (indigenous_community_id) REFERENCES indigenous_communities(id) ON DELETE CASCADE
);