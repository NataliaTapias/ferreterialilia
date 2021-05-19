# Importando las librerías que vamos a utilizar
import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt 
import textacy
from textacy.datasets import Wikipedia
from collections import Counter, defaultdict
import warnings; warnings.simplefilter('ignore')

"""graficos incrustados"""
%matplotlib inline

"""función auxiliar"""
def leer_texto(texto):
    """Funcion auxiliar para leer un archivo de texto"""
    with open(texto, 'r') as text:
        return text.read()
        # Descargando copus de wikipedia
wp = Wikipedia(data_dir='/home/raul/Documents/data', lang='es', version='latest')
wp.download()
"""Chequeando la información descargada"""
wp.info

"""SALIDA: {'data_dir': '/home/raul/Documents/data',
 'description': 'All articles for a given language- and version-specific Wikipedia site snapshot.',
 'name': 'wikipedia',
 'site_url': 'https://meta.wikimedia.org/wiki/Data_dumps'}"""

 for text in wp.texts(min_len=1000, limit=2):
    print(text[:375], "\n")

  """Andorra

Andorra, oficialmente Principado de Andorra , es un pequeño país soberano del suroeste de Europa. Constituido en Estado independiente, de derecho, democrático y social, cuya forma de gobierno es el coprincipado parlamentario. Su territorio está organizado en siete parroquias, con una población total en 2016 de 78.264 habitantes. Su capital es Andorra la Vieja.

Ti 

Argentina

La República Argentina, conocida simplemente como Argentina, es un país soberano de América del Sur, ubicado en el extremo sur y sudeste de dicho subcontinente. Adopta la forma de gobierno republicana, representativa y federal.

El Estado argentino es un Estado federal descentralizado, integrado por un Estado nacional y veintitrés estados provinciales autónomos  """


# Detectando el idioma con taxtacy
saludos = ["Hola", "Hello", "Bonjour", "Guten Tag", "Buon giorno", "Bom dia"]
for saludo in saludos:
    print(textacy.text_utils.detect_language(saludo))