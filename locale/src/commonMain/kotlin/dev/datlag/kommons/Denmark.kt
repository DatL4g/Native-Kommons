package dev.datlag.kommons


data object Denmark : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("DK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("DNK")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(208)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(45)
    override val continent: Continent = Continent.Europe
}