CREATE SEQUENCE IF NOT EXISTS global_seq START WITH 1 INCREMENT BY 5;
CREATE SEQUENCE IF NOT EXISTS user_account_seq START WITH 1 INCREMENT BY 5;

CREATE TABLE user_account (
   id int8 NOT NULL,
   login varchar NOT NULL,
   "name" varchar NULL,
   full_name varchar NULL,
   bio varchar NULL,
   email varchar NULL,
   image varchar NULL,
   CONSTRAINT user_account_email_key UNIQUE (email),
   CONSTRAINT user_account_login_key UNIQUE (login),
   CONSTRAINT user_account_pkey PRIMARY KEY (id)
);

CREATE TABLE timer_group (
  id int8 NOT NULL,
  "name" varchar NULL,
  CONSTRAINT timer_group_pkey PRIMARY KEY (id)
);

CREATE TABLE timer_schedule (
   id int8 NOT NULL,
   "name" varchar NULL,
   weekdays_mask bit(7) NULL,
   CONSTRAINT timer_schedule_pkey PRIMARY KEY (id)
);

CREATE TABLE timer (
   id uuid NOT NULL,
   name varchar NULL,
   description varchar NULL,
   duration interval NULL,
   is_priority bool NULL,
   is_repeat bool NULL,
   is_enabled bool NULL,
   user_account_id int8 NOT NULL,
   timer_group_id int8 NOT NULL,
   timer_schedule_id int8 NOT NULL,
   begin_timestamp timestamp NULL,
   end_timestamp timestamp NULL,
   CONSTRAINT timer_pkey PRIMARY KEY (id),
   CONSTRAINT timer_timer_group_id_fkey FOREIGN KEY (timer_group_id) REFERENCES timer_group(id),
   CONSTRAINT timer_timer_schedule_id_fkey FOREIGN KEY (timer_schedule_id) REFERENCES timer_schedule(id),
   CONSTRAINT timer_user_account_id_fkey FOREIGN KEY (user_account_id) REFERENCES user_account(id)
);

CREATE TABLE timer_log (
   id uuid NOT NULL,
   timer_id uuid NOT NULL,
   duration_logged_in interval NULL,
   CONSTRAINT timer_log_pkey PRIMARY KEY (id),
   CONSTRAINT timer_log_timer_id_fkey FOREIGN KEY (timer_id) REFERENCES timer(id)
);