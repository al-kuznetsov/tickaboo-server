CREATE TABLE timer (id uuid primary key, name varchar, description varchar, duration interval,
                    is_priority boolean, is_repeat boolean, timer_group_id bigint references timer_group(id) NOT NULL,
                    timer_schedule_id bigint references timer_schedule(id) NOT NULL, begin_timestamp timestamp, end_timestamp timestamp);