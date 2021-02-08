# Seeds a set of data that the application should have
# Seeders usually have any starting data (or exported data from a previous application)
# Seeders are also where we create administrative users of the application.

USE reviewlister_db;

INSERT INTO quotes (quote, author,stars) VALUES
  ('Whatever you are, be a good one!', 'Abraham Lincoln', 0),
  ('What is the meaning of Zen? When hungry, eat. When tired, sleep.', 'Zen Master Rishi', 0),
  ('Make your customers more awesome! Upgrade your user, not your product... make people better at something they want to get better at.', 'Kathy Sierra', 0),
  ('You''re going to make mistakes. The real mistake is not learning from them', 'Anonymous', 0),
  ('Sometimes, the best debugger is a good night''s rest. Or a walk.', 'Ryan Orsinger', 0),
  ('Talent is a pursued interest. Anything that you''re willing to practice, you can do.', 'Bob Ross', 0);
