--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE cart (
    id serial PRIMARY KEY,
    created_date timestamp without time zone,
    product_id int,
    quantity integer NOT NULL,
    user_id integer
);


ALTER TABLE public.cart OWNER TO nmadhab;

--
-- Name: cart_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cart_id_seq OWNER TO nmadhab;

--
-- Name: cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.cart_id_seq OWNED BY public.cart.id;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE public.categories (
    id bigint NOT NULL,
    category_name character varying(255),
    description character varying(255),
    image_url character varying(255)
);


ALTER TABLE public.categories OWNER TO nmadhab;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO nmadhab;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: orderitems; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE orderitems (
    order_item_id serial PRIMARY KEY,
    created_date timestamp without time zone,
    order_id integer,
    price double precision,
    product_id int,
    quantity integer
);


ALTER TABLE public.orderitems OWNER TO nmadhab;

--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.orderitems_order_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orderitems_order_item_id_seq OWNER TO nmadhab;

--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.orderitems_order_item_id_seq OWNED BY public.orderitems.order_item_id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    description character varying(255),
    imageurl character varying(255),
    name character varying(255),
    price double precision NOT NULL,
    category_id bigint NOT NULL
);


ALTER TABLE public.products OWNER TO nmadhab;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO nmadhab;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: tokens; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE public.tokens (
    id integer NOT NULL,
    created_date timestamp without time zone,
    token character varying(255),
    user_id integer NOT NULL
);


ALTER TABLE public.tokens OWNER TO nmadhab;

--
-- Name: tokens_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.tokens_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tokens_id_seq OWNER TO nmadhab;

--
-- Name: tokens_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.tokens_id_seq OWNED BY public.tokens.id;


--
-- Name: user_profile; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE user_profile (
    id serial PRIMARY KEY,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    username character varying(255)
);


ALTER TABLE public.user_profile OWNER TO nmadhab;

--
-- Name: user_profile_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.user_profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_profile_id_seq OWNER TO nmadhab;

--
-- Name: user_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.user_profile_id_seq OWNED BY public.user_profile.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255)
);


ALTER TABLE public.users OWNER TO nmadhab;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO nmadhab;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: wishlist; Type: TABLE; Schema: public; Owner: nmadhab
--

CREATE TABLE wishlist (
    id serial PRIMARY KEY,
    created_date timestamp without time zone,
    product_id bigint,
    user_id integer
);


ALTER TABLE public.wishlist OWNER TO nmadhab;

--
-- Name: wishlist_id_seq; Type: SEQUENCE; Schema: public; Owner: nmadhab
--

CREATE SEQUENCE public.wishlist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wishlist_id_seq OWNER TO nmadhab;

--
-- Name: wishlist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nmadhab
--

ALTER SEQUENCE public.wishlist_id_seq OWNED BY public.wishlist.id;


--
-- Name: cart id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.cart ALTER COLUMN id SET DEFAULT nextval('public.cart_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: orderitems order_item_id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.orderitems ALTER COLUMN order_item_id SET DEFAULT nextval('public.orderitems_order_item_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: tokens id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.tokens ALTER COLUMN id SET DEFAULT nextval('public.tokens_id_seq'::regclass);


--
-- Name: user_profile id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.user_profile ALTER COLUMN id SET DEFAULT nextval('public.user_profile_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: wishlist id; Type: DEFAULT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.wishlist ALTER COLUMN id SET DEFAULT nextval('public.wishlist_id_seq'::regclass);


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.cart (id, created_date, product_id, quantity, user_id) FROM stdin;
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.categories (id, category_name, description, image_url) FROM stdin;
\.


--
-- Data for Name: orderitems; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.orderitems (order_item_id, created_date, order_id, price, product_id, quantity) FROM stdin;
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.products (id, description, imageurl, name, price, category_id) FROM stdin;
\.


--
-- Data for Name: tokens; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.tokens (id, created_date, token, user_id) FROM stdin;
\.


--
-- Data for Name: user_profile; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.user_profile (id, email, first_name, last_name, username) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.users (id, email, first_name, last_name, password, role) FROM stdin;
\.


--
-- Data for Name: wishlist; Type: TABLE DATA; Schema: public; Owner: nmadhab
--

COPY public.wishlist (id, created_date, product_id, user_id) FROM stdin;
\.


--
-- Name: cart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.cart_id_seq', 1, false);


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.categories_id_seq', 1, false);


--
-- Name: orderitems_order_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.orderitems_order_item_id_seq', 1, false);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.products_id_seq', 1, false);


--
-- Name: tokens_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.tokens_id_seq', 1, false);


--
-- Name: user_profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.user_profile_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: wishlist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nmadhab
--

SELECT pg_catalog.setval('public.wishlist_id_seq', 1, false);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: orderitems orderitems_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.orderitems
    ADD CONSTRAINT orderitems_pkey PRIMARY KEY (order_item_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: tokens tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_pkey PRIMARY KEY (id);


--
-- Name: user_profile user_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.user_profile
    ADD CONSTRAINT user_profile_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: wishlist wishlist_pkey; Type: CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.wishlist
    ADD CONSTRAINT wishlist_pkey PRIMARY KEY (id);


--
-- Name: tokens fk2dylsfo39lgjyqml2tbe0b0ss; Type: FK CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT fk2dylsfo39lgjyqml2tbe0b0ss FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: wishlist fk6p7qhvy1bfkri13u29x6pu8au; Type: FK CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.wishlist
    ADD CONSTRAINT fk6p7qhvy1bfkri13u29x6pu8au FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: products fkog2rp4qthbtt2lfyhfo32lsw9; Type: FK CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- Name: cart fkpu4bcbluhsxagirmbdn7dilm5; Type: FK CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fkpu4bcbluhsxagirmbdn7dilm5 FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: orderitems fkqu7dfdpbhltsgxfq2ahkdnyv5; Type: FK CONSTRAINT; Schema: public; Owner: nmadhab
--

ALTER TABLE ONLY public.orderitems
    ADD CONSTRAINT fkqu7dfdpbhltsgxfq2ahkdnyv5 FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- PostgreSQL database dump complete
--

