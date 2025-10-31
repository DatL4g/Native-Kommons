package dev.datlag.kommons


data object Luxembourg : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LUX")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(442)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(352)
    override val continent: Continent = Continent.Europe
}