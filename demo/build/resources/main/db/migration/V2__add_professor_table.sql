CREATE TABLE "professor" (

    pf_id serial NOT NULL,
    pf_name character varying(250) NOT NULL,
    pf_last_name  character varying(250) NOT NULL,
    pf_department  character varying(250) NOT NULL,
    pf_email  character varying(250) NOT NULL,
    pf_state BOOLEAN NOT NULL,
    PRIMARY KEY (pf_id)
);
ALTER TABLE "professor" OWNER to postgres;
