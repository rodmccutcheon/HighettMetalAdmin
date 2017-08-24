INSERT INTO clienttypes (level, discount, position) VALUES
  ('Level 1 Dealer 5%', 5, 1),
  ('Level 2 Dealer 10%', 10, 2),
  ('Level 3 / 15%', 15, 3),
  ('Level 4 / 25%', 20, 4),
  ('Level 5 Public 30%', 30, 5);

INSERT INTO clients (code, name, email, username, password) VALUES
  ('CODE123', 'Rod', 'rodmccutcheon@gmail.com', 'rod', 'test123'),
  ('CODE456', 'Suby', 'suby@example.com', 'suby', 'suby123');

INSERT INTO productcategories (name, position) VALUES
  ('Copper', 1),
  ('Gunmetal', 2),
  ('Brass', 3),
  ('Aluminium', 4),
  ('Stainless', 5),
  ('Lead', 6),
  ('Other', 7);

INSERT INTO clientcategorydiscounts (clientid, productcategoryid, clienttypeid) VALUES
  (1, 1, 1),
  (1, 2, 2);

INSERT INTO products (productcategoryid, name, code, price, description, position) VALUES
  (1, 'Milberry', '', 6.93, 'Bright & shiny stripped Copper wire', 1),
  (1, 'Candy', 'Cu Candy', 6.67, 'Clean Copper tube, wire and sheet off cuts.', 2);

INSERT INTO bintypes (name, size, image_path, position) VALUES
  ('Type 211', '1000mm x 1000mm x 1850mm', 'type-211-6350.jpg', 1),
  ('Type 35m3 Dino', '2.4m x 2.4m x 7m', 'type-35m3-dino-9492.jpg', 2),
  ('Type 20m3 Dino', '2m x 2m x 5m', 'type-20m3-dino-3621.jpg', 3),
  ('Type 6x4', '1300mm x 2160mm x 1200mm', 'type-6x4-3336.jpg', 4),
  ('Type 3x2', '1700mm x 1400mm x 850mm', 'type-3x2-2862.jpg', 5),
  ('Type 3x3', '1000mm x 1000mm x 1000mm', 'type-3x3-6874.jpg', 6),
  ('Type Drum', '-', 'type-drum-1659.jpg', 7);