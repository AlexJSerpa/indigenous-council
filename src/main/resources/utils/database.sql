
CREATE TABLE Users (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    first_name NVARCHAR(50) NOT NULL,
    last_name NVARCHAR(50) NOT NULL
);

CREATE TABLE Indigenous_communities (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name NVARCHAR(100) NOT NULL,
    reserve_name NVARCHAR(100) NOT NULL,
    family_number INT,
    user_id UNIQUEIDENTIFIER,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Indigenous (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    first_name NVARCHAR(50) NOT NULL,
    last_name NVARCHAR(50) NOT NULL,
    identification_type NVARCHAR(50) NOT NULL,
    identification_number NVARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    family_member NVARCHAR(20),
    gender NVARCHAR(20) CHECK (gender IN ('Male', 'Female', 'Other')) NOT NULL,
    marital_status NVARCHAR(20) CHECK (marital_status IN ('Single', 'Married', 'Divorced', 'Widowed')),
    profession NVARCHAR(200),
    address NVARCHAR(200),
    phone NVARCHAR(15),
    created_at DATETIME2 DEFAULT SYSDATETIME(),
    updated_at DATETIME2 DEFAULT SYSDATETIME()
);


CREATE TABLE Families (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    indigenous_id UNIQUEIDENTIFIER,
    indigenous_comunities_id UNIQUEIDENTIFIER,
    FOREIGN KEY (indigenous_id) REFERENCES Indigenous(id),
    FOREIGN KEY (indigenous_comunities_id) REFERENCES Indigenous_communities(id)
);
