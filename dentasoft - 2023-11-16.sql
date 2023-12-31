PGDMP  	    8            
    {         	   DentaSoft    16.1    16.0 !    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398 	   DentaSoft    DATABASE     m   CREATE DATABASE "DentaSoft" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "DentaSoft";
                postgres    false            �            1259    16399    cita    TABLE     x  CREATE TABLE public.cita (
    detallecita text NOT NULL,
    fecha date NOT NULL,
    preciocita numeric(8,2) NOT NULL,
    idpaciente integer NOT NULL,
    iddentista integer NOT NULL,
    idcita integer NOT NULL,
    idhorario character varying(50) NOT NULL,
    pagototal numeric(8,2) NOT NULL,
    tipocita character varying(50) DEFAULT ''::character varying NOT NULL
);
    DROP TABLE public.cita;
       public         heap    postgres    false            �            1259    24629    cita_idcita_seq    SEQUENCE     �   CREATE SEQUENCE public.cita_idcita_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.cita_idcita_seq;
       public          postgres    false    215            �           0    0    cita_idcita_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.cita_idcita_seq OWNED BY public.cita.idcita;
          public          postgres    false    219            �            1259    16404    dentista    TABLE       CREATE TABLE public.dentista (
    nombres text NOT NULL,
    dni integer NOT NULL,
    edad integer NOT NULL,
    email text,
    cantidadcitas integer NOT NULL,
    tiempotolerancia integer NOT NULL,
    iddentista integer NOT NULL,
    telefono character varying
);
    DROP TABLE public.dentista;
       public         heap    postgres    false            �            1259    24638    dentista_iddentista_seq    SEQUENCE     �   CREATE SEQUENCE public.dentista_iddentista_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.dentista_iddentista_seq;
       public          postgres    false    216            �           0    0    dentista_iddentista_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.dentista_iddentista_seq OWNED BY public.dentista.iddentista;
          public          postgres    false    220            �            1259    24622    horario    TABLE     �   CREATE TABLE public.horario (
    idhorario character varying(50) NOT NULL,
    horainicio time without time zone NOT NULL,
    horafin time without time zone NOT NULL,
    estado character varying
);
    DROP TABLE public.horario;
       public         heap    postgres    false            �            1259    16409    paciente    TABLE       CREATE TABLE public.paciente (
    nombres text NOT NULL,
    dni integer,
    edad integer NOT NULL,
    sexo text NOT NULL,
    direccion text NOT NULL,
    email text,
    idpaciente integer NOT NULL,
    telefono character varying DEFAULT ''::character varying NOT NULL
);
    DROP TABLE public.paciente;
       public         heap    postgres    false            �            1259    24653    paciente_idpaciente_seq    SEQUENCE     �   CREATE SEQUENCE public.paciente_idpaciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.paciente_idpaciente_seq;
       public          postgres    false    217            �           0    0    paciente_idpaciente_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.paciente_idpaciente_seq OWNED BY public.paciente.idpaciente;
          public          postgres    false    221            (           2604    24630    cita idcita    DEFAULT     j   ALTER TABLE ONLY public.cita ALTER COLUMN idcita SET DEFAULT nextval('public.cita_idcita_seq'::regclass);
 :   ALTER TABLE public.cita ALTER COLUMN idcita DROP DEFAULT;
       public          postgres    false    219    215            *           2604    24639    dentista iddentista    DEFAULT     z   ALTER TABLE ONLY public.dentista ALTER COLUMN iddentista SET DEFAULT nextval('public.dentista_iddentista_seq'::regclass);
 B   ALTER TABLE public.dentista ALTER COLUMN iddentista DROP DEFAULT;
       public          postgres    false    220    216            +           2604    24654    paciente idpaciente    DEFAULT     z   ALTER TABLE ONLY public.paciente ALTER COLUMN idpaciente SET DEFAULT nextval('public.paciente_idpaciente_seq'::regclass);
 B   ALTER TABLE public.paciente ALTER COLUMN idpaciente DROP DEFAULT;
       public          postgres    false    221    217            �          0    16399    cita 
   TABLE DATA           ~   COPY public.cita (detallecita, fecha, preciocita, idpaciente, iddentista, idcita, idhorario, pagototal, tipocita) FROM stdin;
    public          postgres    false    215   D&       �          0    16404    dentista 
   TABLE DATA           t   COPY public.dentista (nombres, dni, edad, email, cantidadcitas, tiempotolerancia, iddentista, telefono) FROM stdin;
    public          postgres    false    216   �&       �          0    24622    horario 
   TABLE DATA           I   COPY public.horario (idhorario, horainicio, horafin, estado) FROM stdin;
    public          postgres    false    218   e'       �          0    16409    paciente 
   TABLE DATA           d   COPY public.paciente (nombres, dni, edad, sexo, direccion, email, idpaciente, telefono) FROM stdin;
    public          postgres    false    217   �'       �           0    0    cita_idcita_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cita_idcita_seq', 4, true);
          public          postgres    false    219            �           0    0    dentista_iddentista_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.dentista_iddentista_seq', 2, true);
          public          postgres    false    220            �           0    0    paciente_idpaciente_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.paciente_idpaciente_seq', 2, true);
          public          postgres    false    221            .           2606    24637    cita cita_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cita
    ADD CONSTRAINT cita_pkey PRIMARY KEY (idcita);
 8   ALTER TABLE ONLY public.cita DROP CONSTRAINT cita_pkey;
       public            postgres    false    215            2           2606    24646    dentista dentista_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.dentista
    ADD CONSTRAINT dentista_pkey PRIMARY KEY (iddentista);
 @   ALTER TABLE ONLY public.dentista DROP CONSTRAINT dentista_pkey;
       public            postgres    false    216            6           2606    24628    horario horario_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT horario_pkey PRIMARY KEY (idhorario);
 >   ALTER TABLE ONLY public.horario DROP CONSTRAINT horario_pkey;
       public            postgres    false    218            4           2606    24661    paciente paciente_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (idpaciente);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public            postgres    false    217            /           1259    24652    fki_fk_cita_dentista    INDEX     K   CREATE INDEX fki_fk_cita_dentista ON public.cita USING btree (iddentista);
 (   DROP INDEX public.fki_fk_cita_dentista;
       public            postgres    false    215            0           1259    24667    fki_fk_cita_paciente    INDEX     K   CREATE INDEX fki_fk_cita_paciente ON public.cita USING btree (idpaciente);
 (   DROP INDEX public.fki_fk_cita_paciente;
       public            postgres    false    215            7           2606    24647    cita fk_cita_dentista    FK CONSTRAINT     �   ALTER TABLE ONLY public.cita
    ADD CONSTRAINT fk_cita_dentista FOREIGN KEY (iddentista) REFERENCES public.dentista(iddentista) NOT VALID;
 ?   ALTER TABLE ONLY public.cita DROP CONSTRAINT fk_cita_dentista;
       public          postgres    false    216    215    4658            8           2606    32814    cita fk_cita_horario    FK CONSTRAINT     �   ALTER TABLE ONLY public.cita
    ADD CONSTRAINT fk_cita_horario FOREIGN KEY (idhorario) REFERENCES public.horario(idhorario) NOT VALID;
 >   ALTER TABLE ONLY public.cita DROP CONSTRAINT fk_cita_horario;
       public          postgres    false    4662    215    218            9           2606    24662    cita fk_cita_paciente    FK CONSTRAINT     �   ALTER TABLE ONLY public.cita
    ADD CONSTRAINT fk_cita_paciente FOREIGN KEY (idpaciente) REFERENCES public.paciente(idpaciente) NOT VALID;
 ?   ALTER TABLE ONLY public.cita DROP CONSTRAINT fk_cita_paciente;
       public          postgres    false    217    4660    215            �   �   x�e�A
� E��)�@�tmu
�8��]o�#�b�����o>�G�>g֑uHՃAc��f �P�e���EJ�(%$���an���c�	��CH�G9
��@�E ���k*^ߤJ�����]�kw��y�R���1!      �   x   x�M�A
�0F���S�%3��ӝ� �E,�sl�BB!�oݕ�||>}�ڜC
��O )��N!��y+!�ʖ���aM�k�p`�(ݞ�j�����|�?<d����,�X�x�����<[c�E!S      �   ;   x�3470�44�20�1,�G.C3c0�"a	e�$@|3�s�S�&a������ �tF      �   �   x���
�0 �/O�=Ai��t3J�@b�����%��6RtЧ��n9n;�O���o�2�0�bE��t́I���p��|�>e��>���6>B*�<�Z�Qi�k:�gs��=�t�^%E�8V.����8������%=     