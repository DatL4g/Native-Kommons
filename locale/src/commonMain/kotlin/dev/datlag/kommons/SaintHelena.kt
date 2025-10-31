package dev.datlag.kommons


data object SaintHelena : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SH")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SHN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(654)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(290)
    override val continent: Continent = Continent.Africa
}