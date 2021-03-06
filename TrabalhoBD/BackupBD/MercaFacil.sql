PGDMP     0    :                v         
   MercaFacil    10.4    10.4 ;    B           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            C           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            D           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            E           1262    16393 
   MercaFacil    DATABASE     �   CREATE DATABASE "MercaFacil" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "MercaFacil";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            F           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            G           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16396    cliente    TABLE     �   CREATE TABLE public.cliente (
    codigo integer NOT NULL,
    nome character varying(50) NOT NULL,
    cpf character(14) NOT NULL,
    rg character varying(10) NOT NULL,
    telefone character(14),
    endereco character varying(100)
);
    DROP TABLE public.cliente;
       public         postgres    false    3            �            1259    16394    cliente_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.cliente_codigo_seq;
       public       postgres    false    3    197            H           0    0    cliente_codigo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.cliente_codigo_seq OWNED BY public.cliente.codigo;
            public       postgres    false    196            �            1259    16411 
   fornecedor    TABLE     �   CREATE TABLE public.fornecedor (
    codigofornecedor integer NOT NULL,
    nome character varying(50) NOT NULL,
    cnpj character(18) NOT NULL,
    telefone character varying(15),
    endereco character varying(100),
    ie character(15) NOT NULL
);
    DROP TABLE public.fornecedor;
       public         postgres    false    3            �            1259    16409    fornecedor_codigofornecedor_seq    SEQUENCE     �   CREATE SEQUENCE public.fornecedor_codigofornecedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.fornecedor_codigofornecedor_seq;
       public       postgres    false    3    199            I           0    0    fornecedor_codigofornecedor_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.fornecedor_codigofornecedor_seq OWNED BY public.fornecedor.codigofornecedor;
            public       postgres    false    198            �            1259    16541    produto    TABLE     }  CREATE TABLE public.produto (
    codigo integer NOT NULL,
    descricao character varying(50) NOT NULL,
    valorcusto double precision NOT NULL,
    lucro double precision NOT NULL,
    icms double precision DEFAULT '0'::double precision,
    ipi double precision DEFAULT '0'::double precision,
    outrosimpostos double precision DEFAULT '0'::double precision,
    estoque integer DEFAULT 0,
    estoqueminimo integer DEFAULT 0 NOT NULL,
    estoquemaximo integer DEFAULT 0 NOT NULL,
    codfornecedor integer NOT NULL,
    CONSTRAINT produto_check CHECK ((estoquemaximo >= estoqueminimo)),
    CONSTRAINT produto_estoque_check CHECK ((estoque >= 0)),
    CONSTRAINT produto_estoqueminimo_check CHECK ((estoqueminimo >= 0)),
    CONSTRAINT produto_lucro_check CHECK ((lucro > (0)::double precision)),
    CONSTRAINT produto_valorcusto_check CHECK ((valorcusto >= (0)::double precision))
);
    DROP TABLE public.produto;
       public         postgres    false    3            �            1259    16539    produto_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.produto_codigo_seq;
       public       postgres    false    3    205            J           0    0    produto_codigo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.produto_codigo_seq OWNED BY public.produto.codigo;
            public       postgres    false    204            �            1259    16563    produtos_venda_prazo    TABLE     s   CREATE TABLE public.produtos_venda_prazo (
    codigovenda integer NOT NULL,
    codigoproduto integer NOT NULL
);
 (   DROP TABLE public.produtos_venda_prazo;
       public         postgres    false    3            �            1259    16578    produtos_venda_vista    TABLE     s   CREATE TABLE public.produtos_venda_vista (
    codigovenda integer NOT NULL,
    codigoproduto integer NOT NULL
);
 (   DROP TABLE public.produtos_venda_vista;
       public         postgres    false    3            �            1259    16466    venda_aprazo    TABLE     �   CREATE TABLE public.venda_aprazo (
    codigo integer NOT NULL,
    datadavenda date NOT NULL,
    codigocliente integer NOT NULL
);
     DROP TABLE public.venda_aprazo;
       public         postgres    false    3            �            1259    16464    venda_aprazo_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_aprazo_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.venda_aprazo_codigo_seq;
       public       postgres    false    3    203            K           0    0    venda_aprazo_codigo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.venda_aprazo_codigo_seq OWNED BY public.venda_aprazo.codigo;
            public       postgres    false    202            �            1259    16458    venda_avista    TABLE     �   CREATE TABLE public.venda_avista (
    codigo integer NOT NULL,
    tipopagamento character varying(8) NOT NULL,
    datadavenda date NOT NULL
);
     DROP TABLE public.venda_avista;
       public         postgres    false    3            �            1259    16456    venda_avista_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_avista_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.venda_avista_codigo_seq;
       public       postgres    false    201    3            L           0    0    venda_avista_codigo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.venda_avista_codigo_seq OWNED BY public.venda_avista.codigo;
            public       postgres    false    200            �
           2604    16595    cliente codigo    DEFAULT     p   ALTER TABLE ONLY public.cliente ALTER COLUMN codigo SET DEFAULT nextval('public.cliente_codigo_seq'::regclass);
 =   ALTER TABLE public.cliente ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    196    197    197            �
           2604    16596    fornecedor codigofornecedor    DEFAULT     �   ALTER TABLE ONLY public.fornecedor ALTER COLUMN codigofornecedor SET DEFAULT nextval('public.fornecedor_codigofornecedor_seq'::regclass);
 J   ALTER TABLE public.fornecedor ALTER COLUMN codigofornecedor DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    16597    produto codigo    DEFAULT     p   ALTER TABLE ONLY public.produto ALTER COLUMN codigo SET DEFAULT nextval('public.produto_codigo_seq'::regclass);
 =   ALTER TABLE public.produto ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    204    205    205            �
           2604    16598    venda_aprazo codigo    DEFAULT     z   ALTER TABLE ONLY public.venda_aprazo ALTER COLUMN codigo SET DEFAULT nextval('public.venda_aprazo_codigo_seq'::regclass);
 B   ALTER TABLE public.venda_aprazo ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    202    203    203            �
           2604    16599    venda_avista codigo    DEFAULT     z   ALTER TABLE ONLY public.venda_avista ALTER COLUMN codigo SET DEFAULT nextval('public.venda_avista_codigo_seq'::regclass);
 B   ALTER TABLE public.venda_avista ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    200    201    201            5          0    16396    cliente 
   TABLE DATA               L   COPY public.cliente (codigo, nome, cpf, rg, telefone, endereco) FROM stdin;
    public       postgres    false    197   �G       7          0    16411 
   fornecedor 
   TABLE DATA               Z   COPY public.fornecedor (codigofornecedor, nome, cnpj, telefone, endereco, ie) FROM stdin;
    public       postgres    false    199   �H       =          0    16541    produto 
   TABLE DATA               �   COPY public.produto (codigo, descricao, valorcusto, lucro, icms, ipi, outrosimpostos, estoque, estoqueminimo, estoquemaximo, codfornecedor) FROM stdin;
    public       postgres    false    205   ^J       >          0    16563    produtos_venda_prazo 
   TABLE DATA               J   COPY public.produtos_venda_prazo (codigovenda, codigoproduto) FROM stdin;
    public       postgres    false    206   �J       ?          0    16578    produtos_venda_vista 
   TABLE DATA               J   COPY public.produtos_venda_vista (codigovenda, codigoproduto) FROM stdin;
    public       postgres    false    207   �J       ;          0    16466    venda_aprazo 
   TABLE DATA               J   COPY public.venda_aprazo (codigo, datadavenda, codigocliente) FROM stdin;
    public       postgres    false    203   K       9          0    16458    venda_avista 
   TABLE DATA               J   COPY public.venda_avista (codigo, tipopagamento, datadavenda) FROM stdin;
    public       postgres    false    201   "K       M           0    0    cliente_codigo_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.cliente_codigo_seq', 5, true);
            public       postgres    false    196            N           0    0    fornecedor_codigofornecedor_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.fornecedor_codigofornecedor_seq', 9, true);
            public       postgres    false    198            O           0    0    produto_codigo_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.produto_codigo_seq', 5, true);
            public       postgres    false    204            P           0    0    venda_aprazo_codigo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.venda_aprazo_codigo_seq', 1, false);
            public       postgres    false    202            Q           0    0    venda_avista_codigo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.venda_avista_codigo_seq', 1, false);
            public       postgres    false    200            �
           2606    16403    cliente cliente_cpf_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);
 A   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_cpf_key;
       public         postgres    false    197            �
           2606    16401    cliente cliente_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public         postgres    false    197            �
           2606    16418    fornecedor fornecedor_cnpj_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_cnpj_key UNIQUE (cnpj);
 H   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_cnpj_key;
       public         postgres    false    199            �
           2606    16455    fornecedor fornecedor_ie_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_ie_key UNIQUE (ie);
 F   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_ie_key;
       public         postgres    false    199            �
           2606    16416    fornecedor fornecedor_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (codigofornecedor);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public         postgres    false    199            �
           2606    16594 +   produto produto_descricao_codfornecedor_key 
   CONSTRAINT     z   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_descricao_codfornecedor_key UNIQUE (descricao, codfornecedor);
 U   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_descricao_codfornecedor_key;
       public         postgres    false    205    205            �
           2606    16557    produto produto_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    205            �
           2606    16567 .   produtos_venda_prazo produtos_venda_prazo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_prazo
    ADD CONSTRAINT produtos_venda_prazo_pkey PRIMARY KEY (codigovenda, codigoproduto);
 X   ALTER TABLE ONLY public.produtos_venda_prazo DROP CONSTRAINT produtos_venda_prazo_pkey;
       public         postgres    false    206    206            �
           2606    16582 .   produtos_venda_vista produtos_venda_vista_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_vista
    ADD CONSTRAINT produtos_venda_vista_pkey PRIMARY KEY (codigovenda, codigoproduto);
 X   ALTER TABLE ONLY public.produtos_venda_vista DROP CONSTRAINT produtos_venda_vista_pkey;
       public         postgres    false    207    207            �
           2606    16471    venda_aprazo venda_aprazo_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.venda_aprazo
    ADD CONSTRAINT venda_aprazo_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.venda_aprazo DROP CONSTRAINT venda_aprazo_pkey;
       public         postgres    false    203            �
           2606    16463    venda_avista venda_avista_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.venda_avista
    ADD CONSTRAINT venda_avista_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.venda_avista DROP CONSTRAINT venda_avista_pkey;
       public         postgres    false    201            �
           2606    16558 "   produto produto_codfornecedor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_codfornecedor_fkey FOREIGN KEY (codfornecedor) REFERENCES public.fornecedor(codigofornecedor);
 L   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_codfornecedor_fkey;
       public       postgres    false    205    199    2728            �
           2606    16573 <   produtos_venda_prazo produtos_venda_prazo_codigoproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_prazo
    ADD CONSTRAINT produtos_venda_prazo_codigoproduto_fkey FOREIGN KEY (codigoproduto) REFERENCES public.produto(codigo);
 f   ALTER TABLE ONLY public.produtos_venda_prazo DROP CONSTRAINT produtos_venda_prazo_codigoproduto_fkey;
       public       postgres    false    2736    205    206            �
           2606    16568 :   produtos_venda_prazo produtos_venda_prazo_codigovenda_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_prazo
    ADD CONSTRAINT produtos_venda_prazo_codigovenda_fkey FOREIGN KEY (codigovenda) REFERENCES public.venda_aprazo(codigo);
 d   ALTER TABLE ONLY public.produtos_venda_prazo DROP CONSTRAINT produtos_venda_prazo_codigovenda_fkey;
       public       postgres    false    2732    203    206            �
           2606    16588 <   produtos_venda_vista produtos_venda_vista_codigoproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_vista
    ADD CONSTRAINT produtos_venda_vista_codigoproduto_fkey FOREIGN KEY (codigoproduto) REFERENCES public.produto(codigo);
 f   ALTER TABLE ONLY public.produtos_venda_vista DROP CONSTRAINT produtos_venda_vista_codigoproduto_fkey;
       public       postgres    false    205    207    2736            �
           2606    16583 :   produtos_venda_vista produtos_venda_vista_codigovenda_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.produtos_venda_vista
    ADD CONSTRAINT produtos_venda_vista_codigovenda_fkey FOREIGN KEY (codigovenda) REFERENCES public.venda_avista(codigo);
 d   ALTER TABLE ONLY public.produtos_venda_vista DROP CONSTRAINT produtos_venda_vista_codigovenda_fkey;
       public       postgres    false    2730    201    207            �
           2606    16472 ,   venda_aprazo venda_aprazo_codigocliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda_aprazo
    ADD CONSTRAINT venda_aprazo_codigocliente_fkey FOREIGN KEY (codigocliente) REFERENCES public.cliente(codigo);
 V   ALTER TABLE ONLY public.venda_aprazo DROP CONSTRAINT venda_aprazo_codigocliente_fkey;
       public       postgres    false    2722    197    203            5   �   x���J�0��ur�r�4�I��0�P�".܄��L�&b��q���l�8���czG�ϗy��x���[�"Ry���A��7�{�A
�!;-�B��5JHE��S�%� �ʱ~��i�\�j���Z�'��}KNq�8���H���HǕ[�@��·�m�9�U�h�������81�3�/y����M���3Bs�920F��qA0�q�!����SJ� "I1      7   s  x�U��n�0F��S�%H�����)T�0H#����61�R&9�,�:,�b^�f;˺�ι�%ە�{-�nJ8G8��%!���Rܙ�}on��={#�[�X�y#�R>��_���x�K>�ӄp?�uY)rj���#�N��eP���i�E\���>4�}��4��c�Ӑ���<�iDo�'b�#��;�Zr�����$H88����b�s��1�bٰr��)I;�Z��+~�/��-�f���JtA����q\��{�T}cؾ^~/d������8��WM�7V\�zGj��e�5�
^~"쎗_%��a����-|�2��V6M�HJ���iBz!]g��f�����Ĕ��`���y�M��b��      =   ]   x�3�tN,*9�8_!%U�,�8�$���@��� s�rZpp�r��1�1�S~Xgb^fYjQ��E����F�F� ��ǐ+F��� `�      >      x������ � �      ?      x������ � �      ;      x������ � �      9      x������ � �     