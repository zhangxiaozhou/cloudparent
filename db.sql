create database authserver;

CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(256) NOT NULL,
                                        `resource_ids` varchar(256) DEFAULT NULL,
                                        `client_secret` varchar(256) DEFAULT NULL,
                                        `scope` varchar(256) DEFAULT NULL,
                                        `authorized_grant_types` varchar(256) DEFAULT NULL,
                                        `web_server_redirect_uri` varchar(256) DEFAULT NULL,
                                        `authorities` varchar(256) DEFAULT NULL,
                                        `access_token_validity` int(11) DEFAULT NULL,
                                        `refresh_token_validity` int(11) DEFAULT NULL,
                                        `additional_information` varchar(4096) DEFAULT NULL,
                                        `autoapprove` varchar(256) DEFAULT NULL,
                                        PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) VALUES ('client1',NULL,'{noop}secret','all','authorization_code,refresh_token,implicit,password,client_credentials','http://localhost:9999/client1/login',NULL,NULL,NULL,NULL,'true');
INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) VALUES ('client2',NULL,'{noop}secret','all','authorization_code,refresh_token,implicit,password,client_credentials','http://localhost:10000/client2/login',NULL,NULL,NULL,NULL,'true');
INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) VALUES ('gateway1',NULL,'{noop}secret','all','authorization_code,refresh_token,implicit,password,client_credentials','http://localhost:8000/login',NULL,NULL,NULL,NULL,'true');
INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) VALUES ('service1',NULL,'{noop}secret','all','authorization_code,refresh_token,implicit,password,client_credentials','http://localhost:10002/login',NULL,NULL,NULL,NULL,'true');