package dev.datlag.kommons


data object SaintBarthelemy : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BL")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BLM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(652)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(590)
    override val continent: Continent = Continent.NorthAmerica
}