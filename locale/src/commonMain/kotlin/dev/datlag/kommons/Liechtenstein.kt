package dev.datlag.kommons


data object Liechtenstein : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LIE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(438)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(423)
    override val continent: Continent = Continent.Europe
}