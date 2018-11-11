alter table city
add column path_to_img varchar(100) default 'https://s-media-cache-ak0.pinimg.com/564x/cf/1e/c4/cf1ec4b0c96e59657a46867a91bb0d1e.jpg';

update city set path_to_img = 'http://samara.go2all.ru/imgs/33/15/60203.jpg' where id = 2077746;
update city set path_to_img = 'https://cs9.pikabu.ru/post_img/big/2017/01/27/9/1485531673120315681.jpg' where id = 2122265;
update city set path_to_img = 'https://cs5.pikabu.ru/post_img/big/2015/12/17/6/145034467819049795.jpg' where id = 2123260;