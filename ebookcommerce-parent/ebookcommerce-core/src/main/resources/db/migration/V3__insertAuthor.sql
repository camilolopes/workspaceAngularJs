INSERT INTO `author` (`ID`, `NAME`, `LASTNAME`, `EMAIL`, `REPO_URL`, `TWITTER`, `SITE`, `NAME_EDITOR`, `PHOTO`, `CV`) VALUES
(1, 'Camilo', 'Lopes', 'camilo@xpto.com', 'http://www.github.com/camilolopes', '@camilolope', 'http://www.camilolopes.com.br', 'Camilo Lopes', 'camilo.jpg', 'Trabalha com desenvolvimento de software desde 2003.'),
(2, 'Edson', 'Gonçalves', 'edson@xpto.com', NULL, NULL, 'http://www.edsongonçalves.com.br', 'Edson Gonçalves', 'user_undefined.jpg', 'Natural de Santo André-SP. Como sócio e um dos fundadores da empresa Integrator Technology and Design, responsável pela área técnica de desenvolvimento de sistemas, tanto em ambiente Cliente/Servidor como em sistemas distribui­dos. Com conhecimento em diversas linguagens de programação, trabalha há vários anos na área de treinamento, consultoria e desenvolvimento.');

INSERT INTO `ebook_has_author` (`ebook_id`, `Author_ID`) VALUES
(2, 2),
(3, 1),
(4, 2),
(5, 1),
(5, 2);