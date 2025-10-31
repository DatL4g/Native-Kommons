package dev.datlag.kommons


data object Germany : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("DE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("DEU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(276)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(49)
    override val continent: Continent = Continent.Europe
}