def donante():
    ayunas = int(input("Estás en ayunas? 1-Si  0-NO\n"))
    if (ayunas == 0):
        edad = int(input("Cuantos años tienes?\n"))
        if (edad >= 18 and edad < 65):
            peso = int(input("Cuanto pesas?\n"))
            if (peso >= 50):
                tensionDi = int(
                    input("Cual es tu tensión arterial diastólica (en mm Hg)\n"))
                if (tensionDi > 50 and tensionDi < 100):
                    tensionSi = int(input("Y la sistólica? (en mm Hg)\n"))
                    if (tensionSi > 90 and tensionSi < 180):
                        pulso = int(input("Cual es tu pulso por minuto?\n"))
                        if (pulso > 50 and pulso < 110):
                            plaquetas = int(
                                input("Cuantas plaquetas tienes? (en cc)\n"))
                            if (plaquetas > 150000):
                                proteinas = int(
                                    input("Cantidad de proteinas? (en gr/dl)\n"))
                                if (proteinas > 6):
                                    sexo = int(
                                        input("eres hombre (0) o mujer (1)?\n"))
                                    if (sexo == 0):
                                        hemo = int(
                                            input("Cuales son tus valores de hemoglobina? (en g/l)\n"))
                                        if (hemo > 13.5):
                                            return True
                                        else:
                                            return False
                                    else:
                                        hemo = int(
                                            input("Cuales son tus valores de hemoglobina? (en g/l)\n"))
                                        if (hemo > 12.5):
                                            return True
                                        else:
                                            return False
                                else:
                                    return False
                            else:
                                return False
                        else:
                            return False
                    else:
                        return False
                else:
                    return False
            else:
                return False
        else:
            return False
    else:
        return False


if (donante()):
    print("ENHORABUENA!! PUEDES DONAR SANGREEEE YUUUJUUUUUUU!!!!!!!11!1")
else:
    print("Nop")
