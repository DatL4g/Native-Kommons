package dev.datlag.kommons


data object Malta : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MT")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MLT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(470)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(356)
    override val continent: Continent = Continent.Europe
}