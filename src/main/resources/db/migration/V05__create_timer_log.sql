CREATE TABLE timer_log (id uuid primary key, duration_logged_in interval,
                        timer_id uuid references timer(id) NOT NULL);