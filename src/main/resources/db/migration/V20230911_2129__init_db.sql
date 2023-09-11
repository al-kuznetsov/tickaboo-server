CREATE TABLE user_account
(
    id        int8    NOT NULL,
    "name"    varchar NULL,
    full_name varchar NULL,
    bio       varchar NULL,
    email     varchar NULL,
    image     varchar NULL,
    CONSTRAINT user_account_pkey PRIMARY KEY (id)
);

CREATE TABLE timer_group
(
    id      int8    NOT NULL,
    "name"  varchar NULL,
    user_id int8    NOT NULL,
    CONSTRAINT timer_group_pkey PRIMARY KEY (id)
);

CREATE TABLE timer_schedule
(
    id            int8    NOT NULL,
    "name"        varchar NULL,
    weekdays_mask bit(7)  NULL,
    CONSTRAINT timer_schedule_pkey PRIMARY KEY (id)
);

CREATE TABLE timer
(
    id                uuid      NOT NULL,
    "name"            varchar   NULL,
    description       varchar   NULL,
    duration          interval  NULL,
    is_priority       bool      NULL,
    is_repeat         bool      NULL,
    timer_group_id    int8      NOT NULL,
    timer_schedule_id int8      NOT NULL,
    begin_timestamp   timestamp NULL,
    end_timestamp     timestamp NULL,
    CONSTRAINT timer_pkey PRIMARY KEY (id)
);

CREATE TABLE timer_log
(
    id                 uuid     NOT NULL,
    duration_logged_in interval NULL,
    timer_id           uuid     NOT NULL,
    CONSTRAINT timer_log_pkey PRIMARY KEY (id)
);