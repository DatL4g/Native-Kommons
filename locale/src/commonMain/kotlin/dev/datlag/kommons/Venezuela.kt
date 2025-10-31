package dev.datlag.kommons


data object Venezuela : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VEN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(862)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(58)
    override val continent: Continent = Continent.SouthAmerica
}