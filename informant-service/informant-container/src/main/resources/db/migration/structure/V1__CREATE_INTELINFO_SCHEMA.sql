DROP TYPE IF EXISTS informed_way CASCADE;
CREATE TYPE informed_way AS ENUM ('IN_PERSON','WRITTEN','EMAIL' ,'OTHERS');

DROP TYPE IF EXISTS intel_description CASCADE;
CREATE TYPE intel_description AS ENUM ('CONTRABAND_STORE_ITEM', 'CONTRABAND_MONEY', 'CONTRABAND_LOADED_ON_CAR', 'OTHERS');


DROP TYPE IF EXISTS intel_status CASCADE;
CREATE TYPE intel_status AS ENUM ('ACCEPTED','DECLINED','INITIALIZED','RE_INITIALIZED');

DROP TYPE IF EXISTS complain_status CASCADE;
CREATE TYPE complain_status AS ENUM ( 'RECEIVED','ACCEPTED','DECLINED');

DROP TYPE IF EXISTS operation_result CASCADE;
CREATE TYPE operation_result AS ENUM ('SUCCESSFUL','UNSUCCESSFUL');

DROP TYPE IF EXISTS operation_status CASCADE;
CREATE TYPE operation_status AS ENUM ('COMPLETED','CANCELED');

DROP TYPE IF EXISTS payment_decision CASCADE;
CREATE TYPE payment_decision AS ENUM ('APPROVED','DECLINED');

DROP TYPE IF EXISTS payment_status CASCADE;
CREATE TYPE payment_status AS ENUM ('INITIALIZED','PAID','EXPIRED');

DROP TABLE IF EXISTS intel_infos CASCADE;
CREATE TABLE intel_infos (
                             id uuid NOT NULL,
                             reference_number VARCHAR(250)  UNIQUE,
                             intel_status intel_status,
                             informed_way informed_way,
                             intel_description intel_description,
                             created_At DATE  DEFAULT CURRENT_DATE,
                             created_by character varying COLLATE pg_catalog."default",
                             created_date TIMESTAMP,
                             modified_by character varying COLLATE pg_catalog."default",
                             modified_date TIMESTAMP,
                             CONSTRAINT intel_info_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS informant CASCADE;
CREATE TABLE informant (
                           id uuid NOT NULL,
                           informant_Code  VARCHAR(100) NOT NULL,
                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           bank_name VARCHAR(100),
                           account_number VARCHAR(100) NOT NULL UNIQUE,
                           intel_info_id uuid NOT NULL,
                           CONSTRAINT informant_pkey PRIMARY KEY (id),
                           CONSTRAINT informant_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);

DROP TABLE IF EXISTS complain CASCADE;
CREATE TABLE complain (
                          id uuid NOT NULL,
                          complain_description VARCHAR(250),
                          complain_status complain_status,
                          reported_At TIMESTAMP,
                          intel_info_id uuid NOT NULL,
                          CONSTRAINT complain_pkey PRIMARY KEY (id),
                          CONSTRAINT complain_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)

);

DROP TABLE IF EXISTS operation CASCADE;
CREATE TABLE operation (
                           id uuid NOT NULL,
                           operation_status operation_status,
                           operation_result operation_result,
                           take_Place_At timestamp,
                           intel_info_id uuid NOT NULL,
                           CONSTRAINT operation_pkey PRIMARY KEY (id),
                           CONSTRAINT operation_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);

DROP TABLE IF EXISTS payment CASCADE;
CREATE TABLE payment (
                         id uuid NOT NULL,
                         amount VARCHAR(50) NOT NULL,
                         payment_status payment_status,
                         payment_decision payment_decision,
                         item_Price VARCHAR(10)  NOT NULL,
                         allowed_Payment VARCHAR(10),
                         payment_Receipt bytea,
                         approved_At TIMESTAMP,
                         created_At TIMESTAMP,
                         intel_info_id uuid NOT NULL,
                         CONSTRAINT payment_pkey PRIMARY KEY (id),
                         CONSTRAINT payment_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)



);

DROP TABLE IF EXISTS employee_profile CASCADE;
CREATE TABLE employee_profile (
                                  id uuid NOT NULL,
                                  company_id VARCHAR(10) NOT NULL,
                                  first_name VARCHAR(25) NOT NULL,
                                  last_name VARCHAR(25) NOT NULL,
                                  decline_reason VARCHAR(25),
                                  declined_At TIMESTAMP,
                                  intel_info_id uuid NOT NULL,
                                  CONSTRAINT employee_profile_pkey PRIMARY KEY (id),
                                  CONSTRAINT employee_profile_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);

DROP TABLE IF EXISTS finance_officer_profile CASCADE;
CREATE TABLE finance_officer_profile (
                                         id uuid NOT NULL,
                                         employee_id VARCHAR(10) NOT NULL,
                                         first_name VARCHAR(25) NOT NULL,
                                         last_name VARCHAR(25) NOT NULL,
                                         payment_decline_reason VARCHAR(25) NOT NULL,
                                         declined_At TIMESTAMP NOT NULL,
                                         intel_info_id uuid NOT NULL,
                                         CONSTRAINT finance_officer_profile_pkey PRIMARY KEY (id),
                                         CONSTRAINT finance_officer_profile_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);

DROP TABLE IF EXISTS contact CASCADE;
CREATE TABLE contact (
                         id uuid NOT NULL,
                         Street_Address VARCHAR(10) NOT NULL ,
                         phone_Number VARCHAR(25) NOT NULL,
                         city VARCHAR(25) NOT NULL,
                         is_Active BOOLEAN,
                         intel_info_id uuid NOT NULL,
    /*informant_id uuid NOT NULL,*/
                         CONSTRAINT contact_pkey PRIMARY KEY (id),
    /*  CONSTRAINT contact_informant_id_fkey FOREIGN KEY (informant_id) REFERENCES informant(id),*/
                         CONSTRAINT contact_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);

DROP TABLE IF EXISTS address CASCADE;
CREATE TABLE address (
                         id uuid NOT NULL,
                         sub_City VARCHAR(10) NOT NULL,
                         street VARCHAR(25) NOT NULL,
                         city VARCHAR(25) NOT NULL,
                         intel_info_id uuid NOT NULL,
                         CONSTRAINT address_pkey PRIMARY KEY (id),
                         CONSTRAINT address_intel_info_id_fkey FOREIGN KEY (intel_info_id) REFERENCES intel_infos(id)
);
