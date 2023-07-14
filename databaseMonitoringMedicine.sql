--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8
-- Dumped by pg_dump version 14.8

-- Started on 2023-07-14 20:14:11

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

--
-- TOC entry 3399 (class 1262 OID 16394)
-- Name: MonitoringMedicine; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "MonitoringMedicine" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Indonesia.1252';


ALTER DATABASE "MonitoringMedicine" OWNER TO postgres;

\connect "MonitoringMedicine"

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
-- TOC entry 209 (class 1259 OID 16395)
-- Name: dokter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dokter (
    iddokter integer NOT NULL,
    namadokter character varying(100)
);


ALTER TABLE public.dokter OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16398)
-- Name: dokter_iddokter_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dokter_iddokter_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dokter_iddokter_seq OWNER TO postgres;

--
-- TOC entry 3400 (class 0 OID 0)
-- Dependencies: 210
-- Name: dokter_iddokter_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dokter_iddokter_seq OWNED BY public.dokter.iddokter;


--
-- TOC entry 211 (class 1259 OID 16399)
-- Name: list_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.list_user (
    user_id integer NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.list_user OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16402)
-- Name: list_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.list_user_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.list_user_user_id_seq OWNER TO postgres;

--
-- TOC entry 3401 (class 0 OID 0)
-- Dependencies: 212
-- Name: list_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.list_user_user_id_seq OWNED BY public.list_user.user_id;


--
-- TOC entry 213 (class 1259 OID 16403)
-- Name: obat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.obat (
    idobat integer NOT NULL,
    namaobat character varying(100) NOT NULL,
    totalstock integer NOT NULL
);


ALTER TABLE public.obat OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16406)
-- Name: obat_idobat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.obat_idobat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.obat_idobat_seq OWNER TO postgres;

--
-- TOC entry 3402 (class 0 OID 0)
-- Dependencies: 214
-- Name: obat_idobat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.obat_idobat_seq OWNED BY public.obat.idobat;


--
-- TOC entry 215 (class 1259 OID 16407)
-- Name: pasien; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pasien (
    namapasien character varying(100),
    idpasien integer NOT NULL,
    idpoli integer NOT NULL,
    iddokter integer NOT NULL,
    idobat integer NOT NULL,
    idstatuspasien integer NOT NULL,
    jumlahobat integer,
    tanggalberobat date
);


ALTER TABLE public.pasien OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16410)
-- Name: pasien_idpasien_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pasien_idpasien_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pasien_idpasien_seq OWNER TO postgres;

--
-- TOC entry 3403 (class 0 OID 0)
-- Dependencies: 216
-- Name: pasien_idpasien_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pasien_idpasien_seq OWNED BY public.pasien.idpasien;


--
-- TOC entry 217 (class 1259 OID 16411)
-- Name: poli; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.poli (
    idpoli integer NOT NULL,
    namapoli character varying(100)
);


ALTER TABLE public.poli OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16414)
-- Name: poli_idpoli_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.poli_idpoli_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.poli_idpoli_seq OWNER TO postgres;

--
-- TOC entry 3404 (class 0 OID 0)
-- Dependencies: 218
-- Name: poli_idpoli_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.poli_idpoli_seq OWNED BY public.poli.idpoli;


--
-- TOC entry 219 (class 1259 OID 16415)
-- Name: ppobat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ppobat (
    idppobat integer NOT NULL,
    tanggal date NOT NULL,
    stockin integer NOT NULL,
    stockout integer NOT NULL,
    idobat integer NOT NULL
);


ALTER TABLE public.ppobat OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16418)
-- Name: ppobat_idppobat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ppobat_idppobat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ppobat_idppobat_seq OWNER TO postgres;

--
-- TOC entry 3405 (class 0 OID 0)
-- Dependencies: 220
-- Name: ppobat_idppobat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ppobat_idppobat_seq OWNED BY public.ppobat.idppobat;


--
-- TOC entry 221 (class 1259 OID 16419)
-- Name: userrole; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.userrole (
    roleid integer NOT NULL,
    rolename character varying(100) NOT NULL
);


ALTER TABLE public.userrole OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16422)
-- Name: role_roleid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_roleid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_roleid_seq OWNER TO postgres;

--
-- TOC entry 3406 (class 0 OID 0)
-- Dependencies: 222
-- Name: role_roleid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_roleid_seq OWNED BY public.userrole.roleid;


--
-- TOC entry 223 (class 1259 OID 16423)
-- Name: statuspasien; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statuspasien (
    idstatuspasien integer NOT NULL,
    statuspasien character varying(100)
);


ALTER TABLE public.statuspasien OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16426)
-- Name: statuspasien_idstatuspasien_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.statuspasien_idstatuspasien_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.statuspasien_idstatuspasien_seq OWNER TO postgres;

--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 224
-- Name: statuspasien_idstatuspasien_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.statuspasien_idstatuspasien_seq OWNED BY public.statuspasien.idstatuspasien;


--
-- TOC entry 3199 (class 2604 OID 16427)
-- Name: dokter iddokter; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dokter ALTER COLUMN iddokter SET DEFAULT nextval('public.dokter_iddokter_seq'::regclass);


--
-- TOC entry 3200 (class 2604 OID 16428)
-- Name: list_user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_user ALTER COLUMN user_id SET DEFAULT nextval('public.list_user_user_id_seq'::regclass);


--
-- TOC entry 3201 (class 2604 OID 16429)
-- Name: obat idobat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.obat ALTER COLUMN idobat SET DEFAULT nextval('public.obat_idobat_seq'::regclass);


--
-- TOC entry 3202 (class 2604 OID 16430)
-- Name: pasien idpasien; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien ALTER COLUMN idpasien SET DEFAULT nextval('public.pasien_idpasien_seq'::regclass);


--
-- TOC entry 3203 (class 2604 OID 16431)
-- Name: poli idpoli; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.poli ALTER COLUMN idpoli SET DEFAULT nextval('public.poli_idpoli_seq'::regclass);


--
-- TOC entry 3204 (class 2604 OID 16432)
-- Name: ppobat idppobat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ppobat ALTER COLUMN idppobat SET DEFAULT nextval('public.ppobat_idppobat_seq'::regclass);


--
-- TOC entry 3206 (class 2604 OID 16433)
-- Name: statuspasien idstatuspasien; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statuspasien ALTER COLUMN idstatuspasien SET DEFAULT nextval('public.statuspasien_idstatuspasien_seq'::regclass);


--
-- TOC entry 3205 (class 2604 OID 16434)
-- Name: userrole roleid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.userrole ALTER COLUMN roleid SET DEFAULT nextval('public.role_roleid_seq'::regclass);


--
-- TOC entry 3378 (class 0 OID 16395)
-- Dependencies: 209
-- Data for Name: dokter; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.dokter (iddokter, namadokter) VALUES (1, 'agung');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (3, 'YULLI');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (4, 'PUTRI');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (5, 'YUYUM');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (6, 'RANI');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (7, 'BOGGY');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (8, 'LINA');
INSERT INTO public.dokter (iddokter, namadokter) VALUES (9, 'VINDYA');


--
-- TOC entry 3380 (class 0 OID 16399)
-- Dependencies: 211
-- Data for Name: list_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.list_user (user_id, username, password, email, role_id) VALUES (1, 'test', 'test', 'test', 1);
INSERT INTO public.list_user (user_id, username, password, email, role_id) VALUES (2, 'tes', 'tes', 'tess', 1);
INSERT INTO public.list_user (user_id, username, password, email, role_id) VALUES (4, 'rizkii', 'rizki', 'rizki', 1);
INSERT INTO public.list_user (user_id, username, password, email, role_id) VALUES (5, 'hedi', 'hedi', 'hedi@gmail.com', 0);
INSERT INTO public.list_user (user_id, username, password, email, role_id) VALUES (3, 'ag', 'agu', 'agung', 0);


--
-- TOC entry 3382 (class 0 OID 16403)
-- Dependencies: 213
-- Data for Name: obat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (3, 'ACYCLOVIR 400MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (4, 'ACYCLOVIR CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (5, 'ALLOPURINOL 100', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (6, 'ALLOPURINOL 300', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (7, 'AMBROXOL', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (8, 'AMBROXOL FORTE SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (9, 'AMBROXOL SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (10, 'AMINOPHYLIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (11, 'AMLODIPIN 10', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (12, 'AMLODIPIN 5', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (13, 'AMOXICILLIN 125MG SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (14, 'AMOXICILLIN 250MG SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (15, 'AMOXICILLIN 500MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (16, 'ANTASID', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (17, 'ANTASIDA SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (18, 'ANTIDIARE/DIATABS', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (19, 'APTOR', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (20, 'ASAM FOLAT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (21, 'ASAM MEFENAMAT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (22, 'ASAM TRANEXAMAT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (23, 'ATORVASTATIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (24, 'AZITHROMISIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (25, 'BETAMETHASON CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (26, 'BEVALEX CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (27, 'BIOMEGA', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (28, 'BISOPROLOL', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (29, 'BROMHEXINE', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (30, 'CAPTOPRIL 12,5', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (31, 'CAPTOPRIL 25', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (32, 'CAPTOPRIL 50', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (33, 'CAVIPLEX', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (34, 'CAZETIN DROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (35, 'CEFADROXIL SYR 125MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (36, 'CEFADROXIL SYR 250MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (37, 'CEFADROXIL 500MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (38, 'CEFIXIME 100 MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (39, 'CEFIXIME 200MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (40, 'CEFIXIME SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (41, 'CETIRIZIN 10 MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (42, 'CETIRIZINE DROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (43, 'CETIRIZIN SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (44, 'CHLORAMFENIKOL CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (45, 'CHLORAMFENIKOL SALEP MATA', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (46, 'CHLORAMPHENICOL TM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (47, 'CHLORAMPHENICOL TT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (48, 'CIPROFLOXACIN 500MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (49, 'CLINDAMYCIN 150MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (50, 'CLINDAMYCIN 300MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (51, 'CLOBETAZOLE CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (52, 'COMBANTRIN SYR', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (53, 'COMBANTRIN TAB', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (54, 'COTRIMOXAZOLE SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (55, 'COTRIMOXAZOLE TAB', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (56, 'CTM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (57, 'CURCUMA', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (58, 'CYCLOFEM INJEKSI', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (59, 'DEPO PROGESTIN INJEKSI', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (60, 'DEVOSIX DROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (61, 'DEXAMETHASON INJEKSI', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (62, 'DEXAMETHASON TAB', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (63, 'DIGOXIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (64, 'DOMPERIDON', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (65, 'DOMPERIDON DROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (66, 'DOMPERIDONE SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (67, 'DOXICILLIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (68, 'EPERISON HCL', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (69, 'FLUCADEX', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (70, 'FLUCADEX SYR', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (71, 'FLUNARIZIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (72, 'FLUTAMOL', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (73, 'FLUTAMOL SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (74, 'FLUTROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (75, 'FORASMA', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (76, 'FUROSEMID', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (77, 'GABAPENTIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (78, 'GEMFIBROZIL 300', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (79, 'GENOINT SALEP MATA', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (80, 'GENTAMYCIN CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (81, 'GENTAMYCIN INJEKSI', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (82, 'GG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (83, 'GLIMEPIRIDE 1MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (84, 'GLIMEPIRIDE 2MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (85, 'GLUCOSAMIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (86, 'GOM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (87, 'GRAFACHLOR', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (88, 'HCT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (89, 'HEMORID', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (90, 'HISTIGO', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (91, 'HUFABION', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (92, 'HUFANEURON', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (93, 'HYDROCORTISON CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (94, 'IBUPROFEN 200', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (95, 'IBUPROFEN 400', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (96, 'IBUPROFEN SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (97, 'IBUPROFREN FORTE SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (98, 'IKADRYL SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (99, 'ISDN 5MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (100, 'KALIUM DICLOFENAC', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (101, 'KALK', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (102, 'KAOTIN SYR', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (103, 'KETOCONAZOLE CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (104, 'KETOCONAZOLE TAB', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (105, 'KETOROLAC INJ', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (106, 'KETOROLAC TAB', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (107, 'KOMPOLAX SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (108, 'LACTO B', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (109, 'LANSOPRAZOL', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (110, 'LEVOFLOXACIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (111, 'LOPERAMID', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (112, 'LORATADIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (113, 'MECOBALAMIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (114, 'MELOXICAM 15', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (115, 'MELOXICAM 7,5', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (116, 'METFORMIN', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (117, 'METHYL PREDNISOLON 4MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (118, 'METOCLOPROPRAMIDE', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (119, 'METRONIDAZOLE SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (120, 'METRONIDAZOLE', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (121, 'MICONAZOLE CREAM', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (122, 'MINOSEP GARGLE', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (123, 'NATRIUM DICLOFENAC', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (124, 'NEURODEX', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (126, 'OBH SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (127, 'OMEPRAZOLE', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (128, 'ONDANSENTRON 8 MG', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (129, 'ONDANSENTRON INJ', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (130, 'ORALIT', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (132, 'PARACETAMOL DROP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (133, 'PARACETAMOL SIRUP', 0);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (1, 'ACETYLCYSTEINE', 79);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (131, 'PARACETAMOL 500 MG', 7);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (2, 'ACYCLOVIR 200MG', 85);
INSERT INTO public.obat (idobat, namaobat, totalstock) VALUES (125, 'NIFEDIPINE', 18);


--
-- TOC entry 3384 (class 0 OID 16407)
-- Dependencies: 215
-- Data for Name: pasien; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('agung', 1, 1, 1, 1, 1, 1, '1994-05-11');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('test', 3, 1, 1, 1, 1, 2, '2023-07-12');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('rirzki', 12, 2, 6, 125, 2, 2, '2023-07-13');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('rirzki', 13, 2, 6, 1, 2, 2, '2023-07-13');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('herma', 14, 3, 5, 1, 2, 10, '2023-07-05');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('tess', 15, 1, 1, 1, 1, 5, '2023-07-13');
INSERT INTO public.pasien (namapasien, idpasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) VALUES ('Test nama pasien', 16, 3, 5, 2, 2, 15, '2023-07-12');


--
-- TOC entry 3386 (class 0 OID 16411)
-- Dependencies: 217
-- Data for Name: poli; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.poli (idpoli, namapoli) VALUES (1, 'UMUM');
INSERT INTO public.poli (idpoli, namapoli) VALUES (2, 'KB');
INSERT INTO public.poli (idpoli, namapoli) VALUES (3, 'KIA');
INSERT INTO public.poli (idpoli, namapoli) VALUES (4, 'GIGI');


--
-- TOC entry 3388 (class 0 OID 16415)
-- Dependencies: 219
-- Data for Name: ppobat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (2, '2023-07-12', 0, 3, 131);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (3, '2023-07-05', 100, 0, 1);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (4, '2023-07-12', 2, 6, 1);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (5, '2023-07-13', 0, 2, 125);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (6, '2023-07-13', 0, 2, 1);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (7, '2023-07-13', 20, 0, 125);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (8, '2023-07-05', 0, 10, 1);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (9, '2023-07-13', 0, 5, 1);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (10, '2023-07-13', 100, 0, 2);
INSERT INTO public.ppobat (idppobat, tanggal, stockin, stockout, idobat) VALUES (11, '2023-07-12', 0, 15, 2);


--
-- TOC entry 3392 (class 0 OID 16423)
-- Dependencies: 223
-- Data for Name: statuspasien; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.statuspasien (idstatuspasien, statuspasien) VALUES (1, 'anggota');
INSERT INTO public.statuspasien (idstatuspasien, statuspasien) VALUES (2, 'umum');


--
-- TOC entry 3390 (class 0 OID 16419)
-- Dependencies: 221
-- Data for Name: userrole; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 210
-- Name: dokter_iddokter_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dokter_iddokter_seq', 10, true);


--
-- TOC entry 3409 (class 0 OID 0)
-- Dependencies: 212
-- Name: list_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.list_user_user_id_seq', 5, true);


--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 214
-- Name: obat_idobat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.obat_idobat_seq', 167, true);


--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 216
-- Name: pasien_idpasien_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pasien_idpasien_seq', 16, true);


--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 218
-- Name: poli_idpoli_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.poli_idpoli_seq', 4, true);


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 220
-- Name: ppobat_idppobat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ppobat_idppobat_seq', 11, true);


--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 222
-- Name: role_roleid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_roleid_seq', 1, false);


--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 224
-- Name: statuspasien_idstatuspasien_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.statuspasien_idstatuspasien_seq', 2, true);


--
-- TOC entry 3209 (class 2606 OID 16436)
-- Name: dokter dokter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dokter
    ADD CONSTRAINT dokter_pkey PRIMARY KEY (iddokter);


--
-- TOC entry 3212 (class 2606 OID 16438)
-- Name: list_user list_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_user
    ADD CONSTRAINT list_user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3215 (class 2606 OID 16440)
-- Name: obat obat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.obat
    ADD CONSTRAINT obat_pkey PRIMARY KEY (idobat);


--
-- TOC entry 3222 (class 2606 OID 16442)
-- Name: pasien pasien_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien
    ADD CONSTRAINT pasien_pkey PRIMARY KEY (idpasien);


--
-- TOC entry 3225 (class 2606 OID 16444)
-- Name: poli poli_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.poli
    ADD CONSTRAINT poli_pkey PRIMARY KEY (idpoli);


--
-- TOC entry 3229 (class 2606 OID 16446)
-- Name: ppobat ppobat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ppobat
    ADD CONSTRAINT ppobat_pkey PRIMARY KEY (idppobat);


--
-- TOC entry 3231 (class 2606 OID 16448)
-- Name: userrole role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.userrole
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);


--
-- TOC entry 3234 (class 2606 OID 16450)
-- Name: statuspasien statuspasien_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statuspasien
    ADD CONSTRAINT statuspasien_pkey PRIMARY KEY (idstatuspasien);


--
-- TOC entry 3207 (class 1259 OID 16451)
-- Name: dokter_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX dokter_idx ON public.dokter USING btree (iddokter);


--
-- TOC entry 3210 (class 1259 OID 16452)
-- Name: list_user_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX list_user_idx ON public.list_user USING btree (user_id);


--
-- TOC entry 3213 (class 1259 OID 16453)
-- Name: obat_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX obat_idx ON public.obat USING btree (idobat);


--
-- TOC entry 3216 (class 1259 OID 16454)
-- Name: pasien_fk1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pasien_fk1_idx ON public.pasien USING btree (iddokter);


--
-- TOC entry 3217 (class 1259 OID 16455)
-- Name: pasien_fk2_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pasien_fk2_idx ON public.pasien USING btree (idpoli);


--
-- TOC entry 3218 (class 1259 OID 16456)
-- Name: pasien_fk3_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pasien_fk3_idx ON public.pasien USING btree (idstatuspasien);


--
-- TOC entry 3219 (class 1259 OID 16457)
-- Name: pasien_fk_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pasien_fk_idx ON public.pasien USING btree (idobat);


--
-- TOC entry 3220 (class 1259 OID 16458)
-- Name: pasien_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pasien_idx ON public.pasien USING btree (idpasien);


--
-- TOC entry 3223 (class 1259 OID 16459)
-- Name: poli_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX poli_idx ON public.poli USING btree (idpoli);


--
-- TOC entry 3226 (class 1259 OID 16460)
-- Name: ppobat_fk_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ppobat_fk_idx ON public.ppobat USING btree (idobat);


--
-- TOC entry 3227 (class 1259 OID 16461)
-- Name: ppobat_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ppobat_idx ON public.ppobat USING btree (idppobat);


--
-- TOC entry 3232 (class 1259 OID 16462)
-- Name: statuspasien_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX statuspasien_idx ON public.statuspasien USING btree (idstatuspasien);


--
-- TOC entry 3235 (class 2606 OID 16463)
-- Name: pasien pasien_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien
    ADD CONSTRAINT pasien_fk FOREIGN KEY (idobat) REFERENCES public.obat(idobat) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3236 (class 2606 OID 16468)
-- Name: pasien pasien_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien
    ADD CONSTRAINT pasien_fk1 FOREIGN KEY (iddokter) REFERENCES public.dokter(iddokter) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3237 (class 2606 OID 16473)
-- Name: pasien pasien_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien
    ADD CONSTRAINT pasien_fk2 FOREIGN KEY (idpoli) REFERENCES public.poli(idpoli) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3238 (class 2606 OID 16478)
-- Name: pasien pasien_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasien
    ADD CONSTRAINT pasien_fk3 FOREIGN KEY (idstatuspasien) REFERENCES public.statuspasien(idstatuspasien) ON DELETE CASCADE;


-- Completed on 2023-07-14 20:14:11

--
-- PostgreSQL database dump complete
--

