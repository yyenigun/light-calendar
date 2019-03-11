/* Each table has auto increment id, created date and updated date.
Updated date can be used for CDC (Change Data Capture) in the future. */

CREATE TABLE calendar (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date datetime NOT NULL,
  updated_date datetime DEFAULT NULL,
  status int(2) NOT NULL DEFAULT '1' COMMENT '0:passive, 1:active',
  display_name varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE calendar_event (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date datetime NOT NULL,
  updated_date datetime DEFAULT NULL,
  status int(2) NOT NULL DEFAULT '1' COMMENT '0:passive, 1:active',
  event_name varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  event_description varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  start_date datetime NOT NULL,
  end_date datetime NOT NULL,
  calendar_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_calendar_calender_event (calendar_id),
  CONSTRAINT FK_calendar_calender_event FOREIGN KEY (calendar_id) REFERENCES calendar (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
