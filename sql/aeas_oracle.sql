 drop user aeas  cascade;

CREATE USER aeas IDENTIFIED BY oracle 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

ALTER USER aeas QUOTA UNLIMITED ON USERS;

GRANT "RESOURCE" TO aeas ;
GRANT "CONNECT" TO aeas ;

drop table aeas_firstcourse;
drop sequence aeas_firstcourse_id;
drop trigger aeas_firstcourse_tr;

CREATE TABLE aeas_firstcourse (
  id number(11,0) NOT NULL,
  grade number(11,0) DEFAULT NULL,
  name varchar2(128) DEFAULT NULL,
  shortname varchar2(32) DEFAULT NULL,
  description varchar2(256) DEFAULT NULL,
  isalive number(1,0) DEFAULT 1,
  PRIMARY KEY (id)
);

create sequence aeas_firstcourse_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_firstcourse_tr before
insert on aeas_firstcourse for each row
begin
	if :New.id is NULL then
      select aeas_firstcourse_id.nextval into :New.id from dual;
    end if;
end;


INSERT INTO aeas_firstcourse VALUES (1,1,'�ʻ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (2,1,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (3,1,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (4,1,'�Ķ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (5,1,'д��','',' ',1);
INSERT INTO aeas_firstcourse VALUES (6,1,'��ѧ���߼�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (7,1,'��ģ','',' ',1);
INSERT INTO aeas_firstcourse VALUES (8,1,'���','',' ',1);
INSERT INTO aeas_firstcourse VALUES (9,1,'�﷨','',' ',1);
INSERT INTO aeas_firstcourse VALUES (10,1,'�����β���','',' ',1);
INSERT INTO aeas_firstcourse VALUES (11,2,'�ʻ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (12,2,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (13,2,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (14,2,'�Ķ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (15,2,'д��','',' ',1);
INSERT INTO aeas_firstcourse VALUES (16,2,'��ѧ���߼�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (17,2,'��ģ','',' ',1);
INSERT INTO aeas_firstcourse VALUES (18,2,'���','',' ',1);
INSERT INTO aeas_firstcourse VALUES (19,2,'�﷨','',' ',1);
INSERT INTO aeas_firstcourse VALUES (20,2,'�����β���','',' ',1);
INSERT INTO aeas_firstcourse VALUES (21,3,'�ʻ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (22,3,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (23,3,'����','',' ',1);
INSERT INTO aeas_firstcourse VALUES (24,3,'�Ķ�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (25,3,'д��','',' ',1);
INSERT INTO aeas_firstcourse VALUES (26,3,'��ѧ���߼�','',' ',1);
INSERT INTO aeas_firstcourse VALUES (27,3,'��ģ','',' ',1);
INSERT INTO aeas_firstcourse VALUES (28,3,'���','',' ',1);
INSERT INTO aeas_firstcourse VALUES (29,3,'�﷨','',' ',1);
INSERT INTO aeas_firstcourse VALUES (30,3,'�����β���','',' ',1);
commit;


DROP TABLE aeas_secondcourse;
DROP sequence aeas_secondcourse_id;
DROP trigger aeas_secondcourse_tr;

CREATE TABLE aeas_secondcourse (
  id number(11,0) NOT NULL,
  name varchar2(128) DEFAULT NULL,
  shortname varchar2(32) DEFAULT NULL,
  firstcourseid number(11,0) DEFAULT NULL,
  description varchar2(256) DEFAULT NULL,
  isalive number(1,0) DEFAULT 1,
  PRIMARY KEY (id)
);

create sequence aeas_secondcourse_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_secondcourse_tr before
insert on aeas_secondcourse for each row
begin
	if :New.id is NULL then
        select aeas_secondcourse_id.nextval into :New.id from dual;
  end if;
end; 
  
INSERT INTO aeas_secondcourse VALUES (1,'5-6�ʻ����+�ص㵥�ʴ���1','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (2,'5-6�ʻ����+�ص㵥�ʴ���2','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (3,'SVA','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (4,'SVB','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (5,'SVC','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (6,'5-6�ʻ����1','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (7,'5-6�ʻ����2','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (8,'5-6�ʻ�����ܸ�ϰ','',1,' ',1);
INSERT INTO aeas_secondcourse VALUES (9,'��������1','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (10,'��������2','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (11,'SLA','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (12,'SLB','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (13,'SLC','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (14,'SLD','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (15,'��������+�ܸ�ϰ1','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (16,'��������+�ܸ�ϰ2','',2,' ',1);
INSERT INTO aeas_secondcourse VALUES (17,'�������1','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (18,'�������2','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (19,'����SSA','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (20,'����SSB','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (21,'����SSC','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (22,'����SSD','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (23,'��������+����1','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (24,'��������+����2','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (25,'�����ܸ�ϰ','',3,' ',1);
INSERT INTO aeas_secondcourse VALUES (26,'AEAS5-6�Ķ�����+�Ķ���������','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (27,'SRA','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (28,'SRB','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (29,'SRC','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (30,'SRD','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (31,'5-6�Ķ�����','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (32,'5-6�Ķ������ܸ�ϰ1','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (33,'5-6�Ķ������ܸ�ϰ2','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (34,'5-6�Ķ������ܸ�ϰ3','',4,' ',1);
INSERT INTO aeas_secondcourse VALUES (35,'д������+�ôʺþ䲹��1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (36,'д������+�ôʺþ䲹��2','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (37,'д����д��֮д��1-1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (38,'д����д��֮д��2-1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (39,'д����д��֮д��2-2','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (40,'д����д��֮д��2-3','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (41,'д����д��֮д��2-4','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (42,'������3-1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (43,'������4-1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (44,'˵����5-1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (45,'д������+����+д���ܸ�ϰ1','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (46,'д������+����+д���ܸ�ϰ2','',5,' ',1);
INSERT INTO aeas_secondcourse VALUES (47,'��ѧ�ʻ�+�߼�����1','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (48,'��ѧ�ʻ�+�߼�����2','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (49,'SMA+�߼�','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (50,'SMB+�߼�','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (51,'SMC+�߼�','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (52,'SMD+�߼�','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (53,'��ѧ����+�߼�1','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (54,'��ѧ����+�߼�2','',6,' ',1);
INSERT INTO aeas_secondcourse VALUES (55,'��ģ1','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (56,'��ģ1��ѧ+����+�Ķ�����','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (57,'��ģ1�ʻ�+����+��������','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (58,'��ģ2','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (59,'��ģ2��ѧ+����+�Ķ�����','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (60,'��ģ2�ʻ�+����+��������','',7,' ',1);
INSERT INTO aeas_secondcourse VALUES (62,'��̿���+����','',8,' ',1);
INSERT INTO aeas_secondcourse VALUES (63,'����Ķ�+�ʻ�','',8,' ',1);
INSERT INTO aeas_secondcourse VALUES (64,'����+��ѧ���','',8,' ',1);
INSERT INTO aeas_secondcourse VALUES (65,'�﷨����1','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (66,'�﷨����2','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (67,'�﷨����3','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (68,'�﷨����4','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (69,'����-1+�����������','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (70,'����-2+�����������','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (71,'����-3+�����������','',9,' ',1);
INSERT INTO aeas_secondcourse VALUES (72,'�����α�������ǿ��1','',10,' ',1);
INSERT INTO aeas_secondcourse VALUES (73,'7-9�ص㵥�ʴ���1','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (74,'7-9�ص㵥�ʴ���2','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (75,'�ص�ʻ㸴ϰ+NVA','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (76,'�ص�ʻ㸴ϰ+NVB','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (77,'�ص�ʻ㸴ϰ+NVC','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (78,'�﷨+NVD','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (79,'�ʻ����Old A + New A','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (80,'�ʻ����New B/C','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (81,'�ʻ���⸴ϰ1','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (82,'�ʻ���⸴ϰ2','',11,' ',1);
INSERT INTO aeas_secondcourse VALUES (83,'NLA','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (84,'NLB','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (85,'NLC','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (86,'NLD','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (87,'�����ܸ�ϰ1','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (88,'�����ܸ�ϰ2','',12,' ',1);
INSERT INTO aeas_secondcourse VALUES (89,'�������һ��1-2-3��+��ӦͼƬ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (90,'�������һ��4-5��+��������-6+��ӦͼƬ','',13,'     ',1);
INSERT INTO aeas_secondcourse VALUES (91,'����������7-8-9��+��ӦͼƬ','',13,'   ',1);
INSERT INTO aeas_secondcourse VALUES (92,'�����������10-11��+���������-12+��ӦͼƬ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (93,'���������-13+��������壨14-15��+��ӦͼƬ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (94,'���������-16+�����������17-18��+��ӦͼƬ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (95,'�����������19-20-21��+��ӦͼƬ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (96,'��������+��ӦͼƬ1','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (97,'��������+��ӦͼƬ2','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (98,'�����ܸ�ϰ+ͼƬ��ϰ','',13,' ',1);
INSERT INTO aeas_secondcourse VALUES (99,'AEAS7-9�Ķ���������+NRA','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (100,'NRB','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (101,'NRC','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (102,'NRD','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (103,'�Ķ�����Old A+NEW A','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (104,'�Ķ�����New B/C','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (105,'�Ķ������ܸ�ϰ1','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (106,'�Ķ������ܸ�ϰ2','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (107,'�Ķ������ܸ�ϰ3','',14,' ',1);
INSERT INTO aeas_secondcourse VALUES (108,'д��-������1-1','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (109,'д��-������1-2','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (110,'д��-������1-3','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (111,'д��-д��-2-1','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (112,'д��-д��-2-2','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (113,'д��-д��-3-1','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (114,'д��-д��-3-2','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (115,'д��-д��-4-1','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (116,'д��-д��-4-2','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (117,'д��-д��-4-3','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (118,'д���ܸ�ϰ+д������+����','',15,' ',1);
INSERT INTO aeas_secondcourse VALUES (119,'NMA+�߼�+7-9��ѧ�ص㵥��1','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (120,'NMB+�߼�+7-9��ѧ�ص㵥��2','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (121,'NMC+�߼�','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (122,'NMD+�߼�','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (123,'��ѧ����+�߼�1','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (124,'��ѧ����+�߼�2','',16,' ',1);
INSERT INTO aeas_secondcourse VALUES (125,'��ģ1','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (126,'��ģ1��ѧ+����+�Ķ�����','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (127,'��ģ1�ʻ�+����+��������','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (128,'��ģ2','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (129,'��ģ2��ѧ+����+�Ķ�����','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (130,'��ģ2�ʻ�+����+��������','',17,' ',1);
INSERT INTO aeas_secondcourse VALUES (131,'��̿���+����','',18,' ',1);
INSERT INTO aeas_secondcourse VALUES (132,'����Ķ�+�ʻ�','',18,' ',1);
INSERT INTO aeas_secondcourse VALUES (133,'����+��ѧ���','',18,' ',1);
INSERT INTO aeas_secondcourse VALUES (134,'�﷨����-�Ӿ�','',19,' ',1);
INSERT INTO aeas_secondcourse VALUES (135,'����-1+�����������','',19,' ',1);
INSERT INTO aeas_secondcourse VALUES (136,'����-2+�����������','',19,' ',1);
INSERT INTO aeas_secondcourse VALUES (137,'����-3+�����������','',19,' ',1);
INSERT INTO aeas_secondcourse VALUES (138,'�����α�������ǿ��1','',20,'   ',1);
INSERT INTO aeas_secondcourse VALUES (139,'VA+L10-12�ص㵥�ʴ���1','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (140,'VA+L10-12�ص㵥�ʴ���2','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (141,'VC','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (142,'VD','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (143,'�ʻ����A-D','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (144,'�ʻ����E-H','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (145,'�ʻ�����ܸ�ϰ1','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (146,'�ʻ�����ܸ�ϰ2','',21,' ',1);
INSERT INTO aeas_secondcourse VALUES (147,'LA','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (148,'LB','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (149,'LC','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (150,'LD','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (151,'LE','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (152,'��������1','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (153,'��������2','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (154,'�����ܸ�ϰ1','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (155,'�����ܸ�ϰ2','',22,' ',1);
INSERT INTO aeas_secondcourse VALUES (156,'�������1','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (157,'�������2','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (158,'�������3','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (159,'�������4','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (160,'�������5','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (161,'�������6','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (162,'�������7','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (163,'�������8','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (164,'�������9','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (165,'��������+�ܸ�ϰ1','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (166,'��������+�ܸ�ϰ2','',23,' ',1);
INSERT INTO aeas_secondcourse VALUES (167,'AEAS10-12�Ķ���������+RA','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (168,'RB','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (169,'RC','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (170,'RD','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (171,'�Ķ�����A/B','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (172,'�Ķ�����C/D','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (173,'�Ķ�����E/F','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (174,'�Ķ�����G/H','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (175,'�Ķ������ܸ�ϰ1','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (176,'�Ķ������ܸ�ϰ2','',24,' ',1);
INSERT INTO aeas_secondcourse VALUES (177,'д������1-1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (178,'д������1-2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (179,'д������2-1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (180,'д������2-2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (181,'д������3-1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (182,'д������3-2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (183,'д������4-1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (184,'д������4-2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (185,'д������4-3','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (186,'д������5-1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (187,'д������5-2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (188,'д������5-3','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (189,'д������+����+�ܸ�ϰ1','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (190,'д������+����+�ܸ�ϰ2','',25,' ',1);
INSERT INTO aeas_secondcourse VALUES (191,'MA+�߼�+��ѧ�ص㵥��1','',26,' ',1);
INSERT INTO aeas_secondcourse VALUES (192,'MB+�߼�+��ѧ�ص㵥��2','',26,'   ',1);
INSERT INTO aeas_secondcourse VALUES (193,'MC+�߼�','',26,' ',1);
INSERT INTO aeas_secondcourse VALUES (194,'MD+�߼�','',26,' ',1);
INSERT INTO aeas_secondcourse VALUES (195,'��ѧ����+�߼�1','',26,' ',1);
INSERT INTO aeas_secondcourse VALUES (196,'��ѧ����+�߼�2','',26,' ',1);
INSERT INTO aeas_secondcourse VALUES (197,'��ģ1','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (198,'��ģ1��ѧ+����+�Ķ�����','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (199,'��ģ1�ʻ�+����+��������','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (200,'��ģ2','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (201,'��ģ2��ѧ+����+�Ķ�����','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (202,'��ģ2�ʻ�+����+��������','',27,' ',1);
INSERT INTO aeas_secondcourse VALUES (203,'��̿���+����','',28,' ',1);
INSERT INTO aeas_secondcourse VALUES (204,'����Ķ�+�ʻ�','',28,' ',1);
INSERT INTO aeas_secondcourse VALUES (205,'����+��ѧ���','',28,' ',1);
INSERT INTO aeas_secondcourse VALUES (206,'�﷨����-�Ӿ�','',29,' ',1);
INSERT INTO aeas_secondcourse VALUES (207,'����-1+�����������','',29,' ',1);
INSERT INTO aeas_secondcourse VALUES (208,'����-2+�����������','',29,' ',1);
INSERT INTO aeas_secondcourse VALUES (209,'����-3+�����������','',29,' ',1);
INSERT INTO aeas_secondcourse VALUES (210,'�����α�������ǿ��1','',30,' ',1);
commit;


DROP TABLE aeas_student;
DROP sequence aeas_student_id;
DROP trigger aeas_student_tr;

CREATE TABLE aeas_student (
  id number(11,0) NOT NULL,
  name varchar2(128) DEFAULT NULL,
  shortname varchar2(32) DEFAULT '',
  grade number(11,0) DEFAULT NULL,
  testscore varchar2(128) DEFAULT NULL,
  targetscore varchar2(128) DEFAULT '',
  examinedate date DEFAULT NULL,
  examineplace varchar2(128) DEFAULT NULL,
  teacherid number(11,0) DEFAULT NULL,
  description varchar2(256) DEFAULT NULL,
  isalive number(1,0) DEFAULT 1,
  PRIMARY KEY (id)
);

create sequence aeas_student_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_student_tr before
insert on aeas_student for each row
begin
  if :New.id is NULL then
    select aeas_student_id.nextval into :New.id from dual;
  end if;
end; 


INSERT INTO aeas_student VALUES (9,'Ҷ��','null',2,'14��','45+',to_date('2015-01-17','YYYY-MM-DD'),'�Ϻ�',3,'',1);
INSERT INTO aeas_student VALUES (10,'������','null',2,'9/15�������','',to_date('2014-09-27','YYYY-MM-DD'),'�Ϻ�',14,'',1);
INSERT INTO aeas_student VALUES (11,'���޺�','null',2,'29��','45+',to_date('2014-10-25','YYYY-MM-DD'),'�Ϻ�',2,'',1);
INSERT INTO aeas_student VALUES (12,'�����','null',2,'27-29','50+',to_date('2015-01-17','YYYY-MM-DD'),'�Ϻ�',7,'',1);
INSERT INTO aeas_student VALUES (13,'¥����','null',2,'30��','50',to_date('2015-01-17','YYYY-MM-DD'),'�Ϻ�',16,'',1);
INSERT INTO aeas_student VALUES (14,'������','null',2,'37��','',to_date('2014-10-25','YYYY-MM-DD'),'�Ϻ�',16,'',1);
INSERT INTO aeas_student VALUES (15,'����','null',2,'26��','',to_date('2014-10-25','YYYY-MM-DD'),'�Ϻ�',16,'',1);
INSERT INTO aeas_student VALUES (16,'������','null',2,'22-23��','null',to_date('2014-11-22','YYYY-MM-DD'),'�Ϻ�',7,'',1);
INSERT INTO aeas_student VALUES (17,'�ܼ���','null',2,'25-27��','50+',to_date('2014-10-25','YYYY-MM-DD'),'�Ϻ�',7,'',1);
INSERT INTO aeas_student VALUES (18,'������','null',2,'19','45',to_date('2014-12-27','YYYY-MM-DD'),'�Ϻ�',5,'',1);
commit;


DROP TABLE aeas_teacher;
DROP sequence aeas_teacher_id;
DROP trigger aeas_teacher_tr;

CREATE TABLE aeas_teacher (
  id number(11,0) NOT NULL,
  name varchar2(128) DEFAULT NULL,
  shortname varchar2(32) DEFAULT NULL,
  phone varchar2(32) DEFAULT NULL,
  ismaster number(1,0) DEFAULT NULL,
  isalive number(1,0) DEFAULT 1,
  PRIMARY KEY (id)
);

create sequence aeas_teacher_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_teacher_tr before
insert on aeas_teacher for each row
begin
	if :New.id is NULL then
      select aeas_teacher_id.nextval into :New.id from dual;
    end if;
end; 


INSERT INTO aeas_teacher VALUES (2,'�޺�Ӣ','��','15618269090',1,1);
INSERT INTO aeas_teacher VALUES (3,'��ٻ','��','13482263654',0,1);
INSERT INTO aeas_teacher VALUES (4,'������','��','13917160923',1,1);
INSERT INTO aeas_teacher VALUES (5,'��  ˬ','��','13564163458',1,1);
INSERT INTO aeas_teacher VALUES (6,'Ҷ��Ǭ','Ǭ','',0,1);
INSERT INTO aeas_teacher VALUES (7,'ʷ�Ѳ�','ʷ','13817250076',1,1);
INSERT INTO aeas_teacher VALUES (8,'��С��','��','',0,1);
INSERT INTO aeas_teacher VALUES (9,'��ɺɺ','��','',0,1);
INSERT INTO aeas_teacher VALUES (10,'�α���','��','',0,1);
INSERT INTO aeas_teacher VALUES (11,'����Ƽ','��','',0,1);
INSERT INTO aeas_teacher VALUES (12,'��һ��','��','',0,1);
INSERT INTO aeas_teacher VALUES (13,'����','��','',0,1);
INSERT INTO aeas_teacher VALUES (14,'Ҷ֦','֦','18721194321',1,1);
INSERT INTO aeas_teacher VALUES (15,'����','��','',0,1);
INSERT INTO aeas_teacher VALUES (16,'�����','��','13774253007',1,1);
INSERT INTO aeas_teacher VALUES (17,'ë����','ë','',0,1);
INSERT INTO aeas_teacher VALUES (18,'������','��','',0,1);
INSERT INTO aeas_teacher VALUES (19,'��԰԰','��','',0,1);
INSERT INTO aeas_teacher VALUES (20,'Ҧ��','Ҧ','',0,1);
INSERT INTO aeas_teacher VALUES (21,'����Ƽ','��','',0,1);
INSERT INTO aeas_teacher VALUES (22,'���','�','',0,1);
INSERT INTO aeas_teacher VALUES (23,'�¾�','��','',0,1);
INSERT INTO aeas_teacher VALUES (24,'��࿼','��࿼','',0,1);
INSERT INTO aeas_teacher VALUES (25,'Nina','Nina','',0,1);
INSERT INTO aeas_teacher VALUES (26,'�Ƽ࿼','�Ƽ࿼','',0,1);
INSERT INTO aeas_teacher VALUES (27,'Vera','Vera','',0,1);
INSERT INTO aeas_teacher VALUES (28,'null','Ҷ֦','18721194321',0,1);
commit;


DROP TABLE aeas_teacherability;
DROP sequence aeas_teacherability_id;
DROP trigger aeas_teacherability_tr;

CREATE TABLE aeas_teacherability (
  id number(11,0) NOT NULL,
  teacherid number(11,0) DEFAULT NULL,
  courseid number(11,0) DEFAULT NULL,
  PRIMARY KEY (id)
);

create sequence aeas_teacherability_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_teacherability_tr before
insert on aeas_teacherability for each row
begin
	if :New.id is NULL then
      select aeas_teacherability_id.nextval into :New.id from dual;
    end if; 
end; 


INSERT INTO aeas_teacherability VALUES (33,4,21);
INSERT INTO aeas_teacherability VALUES (34,4,24);
INSERT INTO aeas_teacherability VALUES (35,4,27);
INSERT INTO aeas_teacherability VALUES (36,4,30);
INSERT INTO aeas_teacherability VALUES (37,4,11);
INSERT INTO aeas_teacherability VALUES (38,4,14);
INSERT INTO aeas_teacherability VALUES (39,4,17);
INSERT INTO aeas_teacherability VALUES (40,4,20);
INSERT INTO aeas_teacherability VALUES (41,4,1);
INSERT INTO aeas_teacherability VALUES (42,4,4);
INSERT INTO aeas_teacherability VALUES (43,4,7);
INSERT INTO aeas_teacherability VALUES (44,4,10);
INSERT INTO aeas_teacherability VALUES (45,2,4);
INSERT INTO aeas_teacherability VALUES (46,2,1);
INSERT INTO aeas_teacherability VALUES (47,2,2);
INSERT INTO aeas_teacherability VALUES (48,2,7);
INSERT INTO aeas_teacherability VALUES (49,2,10);
INSERT INTO aeas_teacherability VALUES (50,2,11);
INSERT INTO aeas_teacherability VALUES (51,2,12);
INSERT INTO aeas_teacherability VALUES (52,2,17);
INSERT INTO aeas_teacherability VALUES (53,2,14);
INSERT INTO aeas_teacherability VALUES (54,2,20);
INSERT INTO aeas_teacherability VALUES (55,2,21);
INSERT INTO aeas_teacherability VALUES (56,2,27);
INSERT INTO aeas_teacherability VALUES (57,2,22);
INSERT INTO aeas_teacherability VALUES (58,2,24);
INSERT INTO aeas_teacherability VALUES (59,2,30);
INSERT INTO aeas_teacherability VALUES (60,3,21);
INSERT INTO aeas_teacherability VALUES (61,3,22);
INSERT INTO aeas_teacherability VALUES (62,3,27);
INSERT INTO aeas_teacherability VALUES (63,3,28);
INSERT INTO aeas_teacherability VALUES (64,3,30);
INSERT INTO aeas_teacherability VALUES (65,3,11);
INSERT INTO aeas_teacherability VALUES (66,3,12);
INSERT INTO aeas_teacherability VALUES (67,3,17);
INSERT INTO aeas_teacherability VALUES (68,3,18);
INSERT INTO aeas_teacherability VALUES (69,3,20);
INSERT INTO aeas_teacherability VALUES (70,3,1);
INSERT INTO aeas_teacherability VALUES (71,3,7);
INSERT INTO aeas_teacherability VALUES (72,3,8);
INSERT INTO aeas_teacherability VALUES (73,3,2);
INSERT INTO aeas_teacherability VALUES (74,3,10);
INSERT INTO aeas_teacherability VALUES (75,5,21);
INSERT INTO aeas_teacherability VALUES (76,5,24);
INSERT INTO aeas_teacherability VALUES (77,5,26);
INSERT INTO aeas_teacherability VALUES (78,5,27);
INSERT INTO aeas_teacherability VALUES (79,5,30);
INSERT INTO aeas_teacherability VALUES (80,5,11);
INSERT INTO aeas_teacherability VALUES (81,5,14);
INSERT INTO aeas_teacherability VALUES (82,5,16);
INSERT INTO aeas_teacherability VALUES (83,5,17);
INSERT INTO aeas_teacherability VALUES (84,5,20);
INSERT INTO aeas_teacherability VALUES (85,5,1);
INSERT INTO aeas_teacherability VALUES (86,5,4);
INSERT INTO aeas_teacherability VALUES (87,5,6);
INSERT INTO aeas_teacherability VALUES (88,5,7);
INSERT INTO aeas_teacherability VALUES (89,5,10);
INSERT INTO aeas_teacherability VALUES (90,6,21);
INSERT INTO aeas_teacherability VALUES (91,6,23);
INSERT INTO aeas_teacherability VALUES (92,6,27);
INSERT INTO aeas_teacherability VALUES (93,6,11);
INSERT INTO aeas_teacherability VALUES (94,6,13);
INSERT INTO aeas_teacherability VALUES (95,6,17);
INSERT INTO aeas_teacherability VALUES (96,6,1);
INSERT INTO aeas_teacherability VALUES (97,6,3);
INSERT INTO aeas_teacherability VALUES (98,6,7);
INSERT INTO aeas_teacherability VALUES (99,7,23);
INSERT INTO aeas_teacherability VALUES (100,7,25);
INSERT INTO aeas_teacherability VALUES (101,7,27);
INSERT INTO aeas_teacherability VALUES (102,7,28);
INSERT INTO aeas_teacherability VALUES (103,7,30);
INSERT INTO aeas_teacherability VALUES (104,7,13);
INSERT INTO aeas_teacherability VALUES (105,7,15);
INSERT INTO aeas_teacherability VALUES (106,7,17);
INSERT INTO aeas_teacherability VALUES (107,7,18);
INSERT INTO aeas_teacherability VALUES (108,7,20);
INSERT INTO aeas_teacherability VALUES (109,7,3);
INSERT INTO aeas_teacherability VALUES (110,7,5);
INSERT INTO aeas_teacherability VALUES (111,7,7);
INSERT INTO aeas_teacherability VALUES (112,7,8);
INSERT INTO aeas_teacherability VALUES (113,7,10);
INSERT INTO aeas_teacherability VALUES (114,8,24);
INSERT INTO aeas_teacherability VALUES (115,8,25);
INSERT INTO aeas_teacherability VALUES (116,8,27);
INSERT INTO aeas_teacherability VALUES (117,8,14);
INSERT INTO aeas_teacherability VALUES (118,8,15);
INSERT INTO aeas_teacherability VALUES (119,8,17);
INSERT INTO aeas_teacherability VALUES (120,8,4);
INSERT INTO aeas_teacherability VALUES (121,8,5);
INSERT INTO aeas_teacherability VALUES (122,8,7);
INSERT INTO aeas_teacherability VALUES (123,9,21);
INSERT INTO aeas_teacherability VALUES (124,9,24);
INSERT INTO aeas_teacherability VALUES (125,9,25);
INSERT INTO aeas_teacherability VALUES (126,9,27);
INSERT INTO aeas_teacherability VALUES (127,9,11);
INSERT INTO aeas_teacherability VALUES (128,9,14);
INSERT INTO aeas_teacherability VALUES (129,9,15);
INSERT INTO aeas_teacherability VALUES (130,9,17);
INSERT INTO aeas_teacherability VALUES (131,9,1);
INSERT INTO aeas_teacherability VALUES (132,9,4);
INSERT INTO aeas_teacherability VALUES (133,9,5);
INSERT INTO aeas_teacherability VALUES (134,9,7);
INSERT INTO aeas_teacherability VALUES (135,10,23);
INSERT INTO aeas_teacherability VALUES (136,10,25);
INSERT INTO aeas_teacherability VALUES (137,10,27);
INSERT INTO aeas_teacherability VALUES (138,10,13);
INSERT INTO aeas_teacherability VALUES (139,10,15);
INSERT INTO aeas_teacherability VALUES (140,10,17);
INSERT INTO aeas_teacherability VALUES (141,10,3);
INSERT INTO aeas_teacherability VALUES (142,10,5);
INSERT INTO aeas_teacherability VALUES (143,10,7);
INSERT INTO aeas_teacherability VALUES (144,11,22);
INSERT INTO aeas_teacherability VALUES (145,11,23);
INSERT INTO aeas_teacherability VALUES (146,11,25);
INSERT INTO aeas_teacherability VALUES (147,11,27);
INSERT INTO aeas_teacherability VALUES (148,11,12);
INSERT INTO aeas_teacherability VALUES (149,11,13);
INSERT INTO aeas_teacherability VALUES (150,11,15);
INSERT INTO aeas_teacherability VALUES (151,11,17);
INSERT INTO aeas_teacherability VALUES (152,11,2);
INSERT INTO aeas_teacherability VALUES (153,11,3);
INSERT INTO aeas_teacherability VALUES (154,11,5);
INSERT INTO aeas_teacherability VALUES (155,11,7);
INSERT INTO aeas_teacherability VALUES (156,12,22);
INSERT INTO aeas_teacherability VALUES (157,12,23);
INSERT INTO aeas_teacherability VALUES (158,12,25);
INSERT INTO aeas_teacherability VALUES (159,12,27);
INSERT INTO aeas_teacherability VALUES (160,12,12);
INSERT INTO aeas_teacherability VALUES (161,12,13);
INSERT INTO aeas_teacherability VALUES (162,12,15);
INSERT INTO aeas_teacherability VALUES (163,12,17);
INSERT INTO aeas_teacherability VALUES (164,12,2);
INSERT INTO aeas_teacherability VALUES (165,12,3);
INSERT INTO aeas_teacherability VALUES (166,12,5);
INSERT INTO aeas_teacherability VALUES (167,12,7);
INSERT INTO aeas_teacherability VALUES (168,13,22);
INSERT INTO aeas_teacherability VALUES (169,13,23);
INSERT INTO aeas_teacherability VALUES (170,13,25);
INSERT INTO aeas_teacherability VALUES (171,13,27);
INSERT INTO aeas_teacherability VALUES (172,13,12);
INSERT INTO aeas_teacherability VALUES (173,13,13);
INSERT INTO aeas_teacherability VALUES (174,13,15);
INSERT INTO aeas_teacherability VALUES (175,13,17);
INSERT INTO aeas_teacherability VALUES (176,13,2);
INSERT INTO aeas_teacherability VALUES (177,13,3);
INSERT INTO aeas_teacherability VALUES (178,13,5);
INSERT INTO aeas_teacherability VALUES (179,13,7);
INSERT INTO aeas_teacherability VALUES (180,14,22);
INSERT INTO aeas_teacherability VALUES (181,14,23);
INSERT INTO aeas_teacherability VALUES (182,14,25);
INSERT INTO aeas_teacherability VALUES (183,14,27);
INSERT INTO aeas_teacherability VALUES (184,14,30);
INSERT INTO aeas_teacherability VALUES (185,14,12);
INSERT INTO aeas_teacherability VALUES (186,14,13);
INSERT INTO aeas_teacherability VALUES (187,14,15);
INSERT INTO aeas_teacherability VALUES (188,14,17);
INSERT INTO aeas_teacherability VALUES (189,14,20);
INSERT INTO aeas_teacherability VALUES (190,14,2);
INSERT INTO aeas_teacherability VALUES (191,14,3);
INSERT INTO aeas_teacherability VALUES (192,14,5);
INSERT INTO aeas_teacherability VALUES (193,14,7);
INSERT INTO aeas_teacherability VALUES (194,14,10);
INSERT INTO aeas_teacherability VALUES (195,15,22);
INSERT INTO aeas_teacherability VALUES (196,15,23);
INSERT INTO aeas_teacherability VALUES (197,15,27);
INSERT INTO aeas_teacherability VALUES (198,15,12);
INSERT INTO aeas_teacherability VALUES (199,15,13);
INSERT INTO aeas_teacherability VALUES (200,15,17);
INSERT INTO aeas_teacherability VALUES (201,15,2);
INSERT INTO aeas_teacherability VALUES (202,15,3);
INSERT INTO aeas_teacherability VALUES (203,15,7);
INSERT INTO aeas_teacherability VALUES (204,16,4);
INSERT INTO aeas_teacherability VALUES (205,16,6);
INSERT INTO aeas_teacherability VALUES (206,16,7);
INSERT INTO aeas_teacherability VALUES (207,16,10);
INSERT INTO aeas_teacherability VALUES (208,16,14);
INSERT INTO aeas_teacherability VALUES (209,16,16);
INSERT INTO aeas_teacherability VALUES (210,16,17);
INSERT INTO aeas_teacherability VALUES (211,16,20);
INSERT INTO aeas_teacherability VALUES (212,16,24);
INSERT INTO aeas_teacherability VALUES (213,16,26);
INSERT INTO aeas_teacherability VALUES (214,16,27);
INSERT INTO aeas_teacherability VALUES (215,16,30);
INSERT INTO aeas_teacherability VALUES (216,17,26);
INSERT INTO aeas_teacherability VALUES (217,17,16);
INSERT INTO aeas_teacherability VALUES (218,17,6);
INSERT INTO aeas_teacherability VALUES (219,23,21);
INSERT INTO aeas_teacherability VALUES (220,23,24);
INSERT INTO aeas_teacherability VALUES (221,23,27);
INSERT INTO aeas_teacherability VALUES (222,23,11);
INSERT INTO aeas_teacherability VALUES (223,23,14);
INSERT INTO aeas_teacherability VALUES (224,23,17);
INSERT INTO aeas_teacherability VALUES (225,23,1);
INSERT INTO aeas_teacherability VALUES (226,23,4);
INSERT INTO aeas_teacherability VALUES (227,23,7);
INSERT INTO aeas_teacherability VALUES (228,19,26);
INSERT INTO aeas_teacherability VALUES (229,19,27);
INSERT INTO aeas_teacherability VALUES (230,19,16);
INSERT INTO aeas_teacherability VALUES (231,19,17);
INSERT INTO aeas_teacherability VALUES (232,19,6);
INSERT INTO aeas_teacherability VALUES (233,19,7);
INSERT INTO aeas_teacherability VALUES (238,20,21);
INSERT INTO aeas_teacherability VALUES (239,20,24);
INSERT INTO aeas_teacherability VALUES (240,20,27);
INSERT INTO aeas_teacherability VALUES (241,20,29);
INSERT INTO aeas_teacherability VALUES (242,20,11);
INSERT INTO aeas_teacherability VALUES (243,20,14);
INSERT INTO aeas_teacherability VALUES (244,20,17);
INSERT INTO aeas_teacherability VALUES (245,20,19);
INSERT INTO aeas_teacherability VALUES (246,20,1);
INSERT INTO aeas_teacherability VALUES (247,20,4);
INSERT INTO aeas_teacherability VALUES (248,20,7);
INSERT INTO aeas_teacherability VALUES (249,20,9);
INSERT INTO aeas_teacherability VALUES (250,21,21);
INSERT INTO aeas_teacherability VALUES (251,21,22);
INSERT INTO aeas_teacherability VALUES (252,21,23);
INSERT INTO aeas_teacherability VALUES (253,21,24);
INSERT INTO aeas_teacherability VALUES (254,21,25);
INSERT INTO aeas_teacherability VALUES (255,21,27);
INSERT INTO aeas_teacherability VALUES (256,21,28);
INSERT INTO aeas_teacherability VALUES (257,21,29);
INSERT INTO aeas_teacherability VALUES (258,21,11);
INSERT INTO aeas_teacherability VALUES (259,21,12);
INSERT INTO aeas_teacherability VALUES (260,21,13);
INSERT INTO aeas_teacherability VALUES (261,21,14);
INSERT INTO aeas_teacherability VALUES (262,21,15);
INSERT INTO aeas_teacherability VALUES (263,21,17);
INSERT INTO aeas_teacherability VALUES (264,21,18);
INSERT INTO aeas_teacherability VALUES (265,21,19);
INSERT INTO aeas_teacherability VALUES (266,21,1);
INSERT INTO aeas_teacherability VALUES (267,21,2);
INSERT INTO aeas_teacherability VALUES (268,21,3);
INSERT INTO aeas_teacherability VALUES (269,21,4);
INSERT INTO aeas_teacherability VALUES (270,21,5);
INSERT INTO aeas_teacherability VALUES (271,21,7);
INSERT INTO aeas_teacherability VALUES (272,21,8);
INSERT INTO aeas_teacherability VALUES (273,21,9);
INSERT INTO aeas_teacherability VALUES (274,25,23);
INSERT INTO aeas_teacherability VALUES (275,25,13);
INSERT INTO aeas_teacherability VALUES (276,25,3);
INSERT INTO aeas_teacherability VALUES (277,27,25);
INSERT INTO aeas_teacherability VALUES (278,27,15);
INSERT INTO aeas_teacherability VALUES (279,27,5);
INSERT INTO aeas_teacherability VALUES (280,24,27);
INSERT INTO aeas_teacherability VALUES (281,24,17);
INSERT INTO aeas_teacherability VALUES (282,24,7);
INSERT INTO aeas_teacherability VALUES (283,26,27);
INSERT INTO aeas_teacherability VALUES (284,26,17);
INSERT INTO aeas_teacherability VALUES (285,26,7);
INSERT INTO aeas_teacherability VALUES (286,22,23);
INSERT INTO aeas_teacherability VALUES (287,22,25);
INSERT INTO aeas_teacherability VALUES (288,22,13);
INSERT INTO aeas_teacherability VALUES (289,22,15);
INSERT INTO aeas_teacherability VALUES (290,22,3);
INSERT INTO aeas_teacherability VALUES (291,22,5);
commit;


DROP TABLE aeas_teacherdefaultholiday;
DROP sequence aeas_teacherdefaultholiday_id;
DROP trigger aeas_teacherdefaultholiday_tr;

CREATE TABLE aeas_teacherdefaultholiday (
  id number(11,0) NOT NULL,
  teacherid number(11,0) DEFAULT NULL,
  weak1 number(1) DEFAULT 0,
  weak2 number(1) DEFAULT 0,
  weak3 number(1) DEFAULT 0,
  weak4 number(1) DEFAULT 0,
  weak5 number(1) DEFAULT 0,
  weak6 number(1) DEFAULT 0,
  weak7 number(1) DEFAULT 0,
  PRIMARY KEY (id)
);

create sequence aeas_teacherdefaultholiday_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_teacherdefaultholiday_tr before
insert on aeas_teacherdefaultholiday for each row
begin
	if :New.id is NULL then
      select aeas_teacherdefaultholiday_id.nextval into :New.id from dual;
    end if; 
end;   



INSERT INTO aeas_teacherdefaultholiday VALUES (2,2,1,0,0,1,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (3,3,1,0,1,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (4,4,0,0,1,0,0,0,1);
INSERT INTO aeas_teacherdefaultholiday VALUES (5,5,1,1,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (6,6,0,1,0,0,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (7,7,1,1,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (8,8,0,1,1,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (9,9,0,0,0,1,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (10,10,0,1,0,0,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (11,11,1,0,0,1,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (12,12,0,0,1,0,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (13,13,0,0,1,1,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (14,14,0,0,1,1,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (15,15,0,1,0,0,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (16,16,1,1,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (17,17,0,0,1,1,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (18,18,0,0,0,1,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (19,19,1,0,0,0,1,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (20,20,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (21,21,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (22,22,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (23,23,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (24,24,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (25,25,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (26,26,0,0,0,0,0,0,0);
INSERT INTO aeas_teacherdefaultholiday VALUES (27,27,0,0,0,0,0,0,0);
commit;


DROP TABLE aeas_teacherholiday;
DROP sequence aeas_teacherholiday_id;
DROP trigger aeas_teacherholiday_tr;

CREATE TABLE aeas_teacherholiday (
  id number(11,0) NOT NULL,
  teacherid number(11,0) DEFAULT NULL,
  adjustdate date DEFAULT NULL,
  isholiday number(1,0) DEFAULT '0',
  PRIMARY KEY (id)
);

create sequence aeas_teacherholiday_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_teacherholiday_tr before
insert on aeas_teacherholiday for each row
begin
	if :New.id is NULL then
      select aeas_teacherholiday_id.nextval into :New.id from dual;
    end if; 
end;


INSERT INTO aeas_teacherholiday VALUES (1,2,to_date('2014-10-16','yyyy-mm-dd'),0);


DROP TABLE aeas_schedule;
DROP sequence aeas_schedule_id;
DROP trigger aeas_schedule_tr;

CREATE TABLE aeas_schedule (
  id number(11,0) NOT NULL,
  ondate date DEFAULT NULL,
  ontime number(11,0) DEFAULT NULL,
  studentid number(11,0) DEFAULT NULL,
  courseid number(11,0) DEFAULT NULL,
  teacherid number(11,0) DEFAULT NULL,
  addition varchar2(32) DEFAULT NULL,
  description varchar2(256) DEFAULT NULL,
  PRIMARY KEY (id)
);

create sequence aeas_schedule_id 
  increment by 1
  start with 1000
  nomaxvalue
  nocycle;
  
create trigger aeas_schedule_tr before
insert on aeas_schedule for each row
begin
	if :New.id is NULL then
      select aeas_schedule_id.nextval into :New.id from dual;
    end if; 
end;
  
